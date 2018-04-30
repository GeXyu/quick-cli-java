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
     * @param id
     * @return
     */
    UserModel findAll(Integer id);
    
    /**
     * 根据用户查询用户组
     * @param id
     * @return
     */
    GroupModel findGroup(Integer id);
    
    /**
     * 查询权限
     * @param id
     * @return
     */
    ResourceModel findResource(Integer id);

}
