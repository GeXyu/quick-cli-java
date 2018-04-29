/*
 * $Id: UserServiceImpl.java, 2018年4月29日 下午8:17:16 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xiuyu.user.model.UserModel;
import cn.xiuyu.user.repository.UserRepository;
import cn.xiuyu.user.service.UserService;

/**
 * <p>
 * Title: UserServiceImpl
 * </p>
 * <p>
 * Description:用户服务具体实现
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月29日 下午8:17:16
 * @modified [who date description]
 * @check [who date description]
 */
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void test() {
        System.out.println(userRepository);
        UserModel user = new UserModel();
        user.setUsername("test");
        user.setEnable(Byte.valueOf("1"));
        user.setPassword("123123");
        userRepository.save(user);
        System.out.println("保存成功");
    }

}
