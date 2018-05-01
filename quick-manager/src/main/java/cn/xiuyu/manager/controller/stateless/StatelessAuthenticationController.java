/*
 * $Id: StatelessAuthenticationController.java, 2018年5月1日 下午4:03:23 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.controller.stateless;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.core.util.HmacSHA256Utils;
import cn.xiuyu.manager.data.MVCResult;
import cn.xiuyu.manager.data.StatelessAuthenticationToken;

/**
 * <p>
 * Title: StatelessAuthenticationController
 * </p>
 * <p>
 * Description:认证controler
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午4:03:23
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
@RequestMapping("manager/stateless")
public class StatelessAuthenticationController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public MVCResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Encoder.encode(password.getBytes()));
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            return MVCResult.buildFalseResult(new RuntimeException("错误的账号"));
        } catch (IncorrectCredentialsException e) {
            return MVCResult.buildFalseResult(new RuntimeException("错误的凭证"));
        } catch (LockedAccountException e) {
            return MVCResult.buildFalseResult(new RuntimeException("锁定的账号"));
        }

        // 构造Token
        String kengen = String.valueOf(System.currentTimeMillis());
        StatelessAuthenticationToken statelessToken = new StatelessAuthenticationToken();
        statelessToken.setKengen(kengen);
        statelessToken.setNonce(HmacSHA256Utils.digest(kengen, username));
        statelessToken.setUser(username);
        return MVCResult.buildTrueResult(kengen);
    }
}
