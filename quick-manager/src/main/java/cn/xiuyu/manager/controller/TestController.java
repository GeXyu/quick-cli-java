/*
 * $Id: TestController.java, 2018年4月29日 下午9:55:03 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.xiuyu.user.service.UserService;

/**
 * <p>
 * Title: TestController
 * </p>
 * <p>
 * Description:测试
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月29日 下午9:55:03
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
public class TestController {

    @Reference
    private UserService userService;

    /**
     * 测试
     */
    @RequestMapping("test1")
    public void test1() {
        userService.test();
    }

}
