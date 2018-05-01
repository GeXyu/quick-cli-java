/*
 * $Id: UserController.java, 2018年4月30日 下午12:13:19 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.controller.user;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.manager.data.MVCResult;
import cn.xiuyu.user.model.UserModel;
import cn.xiuyu.user.service.UserService;

/**
 * <p>
 * Title: UserController
 * </p>
 * <p>
 * Description:用户controller
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午12:13:19
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
@RequestMapping("manager/user/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public MVCResult save(@RequestBody UserModel user) {
        try {
            System.out.println(userService);
            user.setPassword(MD5Encoder.encode(user.getPassword().getBytes()));
            user.setCreateTime(new Date());

            userService.save(user);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public MVCResult update(@RequestBody UserModel user) {
        try {
            userService.update(user);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    /**
     * 更新
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "show/{id}")
    public MVCResult show(@PathVariable Integer id) {
        try {
            UserModel user = userService.show(id);
            return MVCResult.buildTrueResult(user);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping(value = "delete/{id}")
    public MVCResult delete(@PathVariable Integer id) {
        try {
            UserModel user = userService.delete(id);
            return MVCResult.buildTrueResult(user);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping("test")
    @RequiresRoles("test")
    @RequiresPermissions("test")
    public MVCResult test() {
        try {
            System.out.println("test");
            System.out.println(userService);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }

    }
}
