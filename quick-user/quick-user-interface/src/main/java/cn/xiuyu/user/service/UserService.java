/*
 * $Id: UserService.java, 2018年4月29日 下午8:15:11 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.user.service;

import java.util.List;

import cn.xiuyu.core.service.base.BaseService;
import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.model.UserModel;

/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description:用户服务
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月29日 下午8:15:11
 * @modified [who date description]
 * @check [who date description]
 */
public interface UserService extends BaseService<UserModel, Integer> {

    /**
     * 测试
     *
     */
    void test();

    /**
     * 查询所有
     * 
     * @param id
     * @return
     */
    UserModel findAll(Integer id);

    /**
     * 根据用户查询用户组
     * 
     * @param id
     * @return
     */
    List<GroupModel> findGroup(Integer id);

    /**
     * 查询权限
     * 
     * @param id
     * @return
     */
    List<ResourceModel> findResource(Integer id);

    /**
     * 根据用户名查询
     * 
     * @param username
     */
    UserModel findByUsername(String username);

    /**
     * 是否存在黑名单
     * 
     * @param token
     * @return
     */
    Boolean isExistBlacklist(String token);

    /**
     * 存放到黑名单
     * 
     * @param token
     * @return
     */
    String addBlacklist(String token);



}
