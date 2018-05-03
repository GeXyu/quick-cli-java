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
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.xiuyu.core.util.DateUtils;
import cn.xiuyu.core.util.JWTUtils;
import cn.xiuyu.core.util.JWTUtils.TokenStatus;
import cn.xiuyu.user.service.UserService;

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
@Component
public class StatelessAccessControlFilter extends AccessControlFilter {

    @Autowired
    private UserService userService;

    /**
     * 临界时间
     */
    private static Long criticalTime = 60L * 20L;

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

        String xAuthenticateNonce = request.getHeader("x-Authenticate-token");
        // 检查token
        TokenStatus tokenStatus = JWTUtils.verifyJwt(xAuthenticateNonce);
        // 说明正常
        if (tokenStatus.equals(TokenStatus.NORMAL)) {
            // 需要查看是否在黑名单
            if (existBlackList(xAuthenticateNonce)) {
                return false;
            }

            // 如果没有在黑名单需要查看是否即将过期，如果过期需要置换
            if (DateUtils.getDiffRetLong(new Date(), JWTUtils.getDate(xAuthenticateNonce)) < criticalTime) {
                response.setHeader("x-Authenticate-token",
                        JWTUtils.generateToken(JWTUtils.getUser(xAuthenticateNonce)));
            }
            return true;
        } else if (tokenStatus.equals(TokenStatus.EXPIRED)) { // 说明事过期，需要重新登陆
            noAuthenticaateHandle(response);
            return false;
        } else if (tokenStatus.equals(TokenStatus.ILLEGAL)) {// 说明事非法数据
            return false;
        }
        return false;
    }

    /**
     * 是否存在黑名单
     * 
     * @param xAuthenticateNonce
     * @return
     */
    private boolean existBlackList(String xAuthenticateNonce) {
        return userService.isExistBlacklist(xAuthenticateNonce);
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
