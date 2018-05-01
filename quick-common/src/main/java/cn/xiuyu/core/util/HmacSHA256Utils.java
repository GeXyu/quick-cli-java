/*
 * $Id: HmacSHA256Utils.java, 2018年5月1日 上午11:49:49 XiuYu.Ge Exp $
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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * <p>
 * Title: HmacSHA256Utils
 * </p>
 * <p>
 * Description:Hmac加密
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 上午11:49:49
 * @modified [who date description]
 * @check [who date description]
 */
public class HmacSHA256Utils {

    /**
     * 加密
     * 
     * @param key
     * @param content
     * @return
     */
    public static String digest(String key, String content) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            mac.init(signingKey);

            byte[] doFinal = mac.doFinal(content.getBytes());
            byte[] hexFinal = new Hex().encode(doFinal);

            return new String(hexFinal, "utf-8");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
