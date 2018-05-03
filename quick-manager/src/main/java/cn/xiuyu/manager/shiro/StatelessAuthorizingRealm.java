/*
 * $Id: StatelessAuthorizingRealm.java, 2018年5月1日 下午3:46:50 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.xiuyu.core.util.MD5Utils;
import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.model.UserModel;
import cn.xiuyu.user.service.UserService;

/**
 * <p>
 * Title: StatelessAuthorizingRealm
 * </p>
 * <p>
 * Description:认证realm
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午3:46:50
 * @modified [who date description]
 * @check [who date description]
 */
@Component
public class StatelessAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * 
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        String username = String.valueOf(principals.getPrimaryPrincipal());
        final UserModel userModel = userService.findByUsername(username);
        List<GroupModel> groupList = userService.findGroup(userModel.getId());
        groupList.stream().forEach(group -> {
            simpleAuthorizationInfo.addRole(group.getGroupName());
        });
        List<ResourceModel> reourceList = userService.findResource(userModel.getId());
        reourceList.stream().forEach(resource -> {
            simpleAuthorizationInfo.addStringPermission(resource.getUrl());
        });
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * 
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());

        UserModel userModel = userService.findByUsername(username);
        if (userModel == null) {
            // 账号不存在
            throw new UnknownAccountException();
        }

        // 密码错误
        if (!MD5Utils.encrypt(password).equals(userModel.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }

}
