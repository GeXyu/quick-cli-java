/*
 * $Id: StatelessAccessControlFilter.java, 2018年5月1日 下午3:10:06 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

import cn.xiuyu.core.util.HmacSHA256Utils;

/**
 * <p>
 * Title: StatelessAccessControlFilter
 * </p>
 * <p>
 * Description:认证器
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午3:10:06
 * @modified [who date description]
 * @check [who date description]
 */
public class StatelessAccessControlFilter extends AccessControlFilter {

    /**
     * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, java.lang.Object)
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object arg2) throws Exception {
        return false;
    }

    /**
     * @see org.apache.shiro.web.filter.AccessControlFilter#onAccessDenied(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse)
     */
    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse resp) throws Exception {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String xAuthenticateNonce = request.getHeader("x-Authenticate-nonce");
        String xAuthenticateUser = request.getHeader("x-Authenticate-user");
        String xAuthenticateKengen = request.getHeader("x-Authenticate-kengen");

        if (xAuthenticateUser == null || xAuthenticateKengen == null || xAuthenticateNonce == null) {
            noAuthenticaateHandle(response);
            return false;
        }

        if (HmacSHA256Utils.digest(xAuthenticateKengen, xAuthenticateUser).equals(xAuthenticateNonce)) {
            // 直接通过
            return true;
        } else {
            noAuthenticaateHandle(response);
            return false;
        }
    }

    /**
     * @param response
     * @throws IOException
     */
    private void noAuthenticaateHandle(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("403");
    }

}
