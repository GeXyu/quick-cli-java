/*
 * $Id: GroupService.java, 2018年4月30日 下午2:09:48 XiuYu.Ge Exp $
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

import org.springframework.data.domain.Page;

import cn.xiuyu.core.service.base.BaseService;
import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.model.UserModel;

/**
 * <p>
 * Title: GroupService
 * </p>
 * <p>
 * Description:用户组
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午2:09:48
 * @modified [who date description]
 * @check [who date description]
 */
public interface GroupService extends BaseService<GroupModel, Integer> {

    /**
     * 列表
     * 
     * @return
     */
    Page<GroupModel> list(Integer currPage,Integer pageSize);

    /**
     * 
     * @return
     */
    GroupModel findAll(Integer id);

    /**
     * 查詢用戶
     * @param id
     * @return
     */
    List<UserModel> findUser(Integer id);
    
    /**
     * 查询资源
     * @param id
     * @return
     */
    List<ResourceModel> findResouce(Integer id);
    
    /**
     * 关联用户
     * @param groupid
     * @param users
     */
    void relationUser(Integer groupid,List<Integer> users);
    
    
    /**
     * 关联资源 
     * @param groupid
     * @param resources
     */
    void relationResource(Integer groupid,List<Integer> resources);

}
