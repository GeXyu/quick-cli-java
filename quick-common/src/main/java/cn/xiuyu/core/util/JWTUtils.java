/*
 * $Id: JWTUtil.java, 2018年5月2日 下午9:49:11 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * <p>
 * Title: JWTUtil
 * </p>
 * <p>
 * Description:jwt
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月2日 下午9:49:11
 * @modified [who date description]
 * @check [who date description]
 */
public class JWTUtils {

    /**
     * 密钥
     */
    private static final String SECRETKEY = "@#$@%@$%#@$@DFGSseksg55sfgs";// 可配置

    private static final String JWT_KEY = "user";

    /**
     * 2个小时
     */
    private static final Integer TIME_OUT = 3600000 * 2;

    /**
     * 生成token
     * 
     * @param user
     * @return
     */
    public static String generateToken(String user) {
        try {
            Algorithm al = Algorithm.HMAC256(SECRETKEY);
            return JWT.create().withClaim(JWT_KEY, user).withExpiresAt(new Date(System.currentTimeMillis() + TIME_OUT))
                    .sign(al);
        } catch (IllegalArgumentException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取过期时间
     * 
     * @param token
     * @return
     */
    public static Date getDate(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt();
    }

    /**
     * 获取用户
     * 
     * @param token
     * @return
     */
    public static String getUser(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaims().get(JWT_KEY).asString();
    }

    /**
     * 校验
     * 
     * @param token
     * @return
     */
    public static TokenStatus verifyJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            if (token != null) {
                verifier.verify(token);
                return TokenStatus.NORMAL;
            }
            return TokenStatus.ILLEGAL;
        } catch (TokenExpiredException e) {
            return TokenStatus.EXPIRED;
        } catch (IllegalArgumentException e) {
            return TokenStatus.ILLEGAL;
        } catch (UnsupportedEncodingException e) {
            return TokenStatus.ILLEGAL;
        } catch (JWTVerificationException e) {
            return TokenStatus.ILLEGAL;
        }
    }

    public enum TokenStatus {
        NORMAL("normal", "正常"), EXPIRED("EXPIRED", "过期"), ILLEGAL("illegal", "非法");
        private String key;
        private String value;

        /**
         * @return the key
         */
        public String getKey() {
            return key;
        }

        /**
         * @param key
         *            the key to set
         */
        public void setKey(String key) {
            this.key = key;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         *            the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * @param key
         * @param value
         */
        private TokenStatus(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }
}
