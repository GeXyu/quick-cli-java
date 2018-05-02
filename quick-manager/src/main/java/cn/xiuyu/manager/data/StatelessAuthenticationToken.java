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
    private String token;

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     */
    public StatelessAuthenticationToken() {
        super();
    }

    /**
     * @param token
     */
    public StatelessAuthenticationToken(String token) {
        super();
        this.token = token;
    }

}
