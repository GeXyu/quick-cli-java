/*
 * $Id: StatelessAuthenticationToken.java, 2018年5月1日 下午4:13:32 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.data;

/**
 * <p>
 * Title: StatelessAuthenticationToken
 * </p>
 * <p>
 * Description:用于返回认证信息
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午4:13:32
 * @modified [who date description]
 * @check [who date description]
 */
public class StatelessAuthenticationToken {

    // token
    private String nonce;

    // 用戶名
    private String user;

    // 用于生成密钥
    private String kengen;

    /**
     * @return the nonce
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * @param nonce
     *            the nonce to set
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the kengen
     */
    public String getKengen() {
        return kengen;
    }

    /**
     * @param kengen
     *            the kengen to set
     */
    public void setKengen(String kengen) {
        this.kengen = kengen;
    }

    /**
     * 
     */
    public StatelessAuthenticationToken() {
        super();
    }

}
