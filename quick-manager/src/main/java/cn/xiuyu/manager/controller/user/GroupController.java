/*
 * $Id: GroupController.java, 2018年4月30日 下午1:04:12 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.manager.data.MVCResult;
import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.service.GroupService;

/**
 * <p>
 * Title: GroupController
 * </p>
 * <p>
 * Description:用户组
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午1:04:12
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
@RequestMapping("manager/user/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    // @Reference 兼容
    // private GroupService groupService1;

    /**
     * 保存
     * 
     * @param group
     * @return
     */
    @RequestMapping("save")
    public MVCResult save(@RequestBody GroupModel group) {
        try {
            groupService.save(group);
            return MVCResult.buildTrueResult(group);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }

    }

    /**
     * 展示
     * 
     * @param id
     * @return
     */
    @RequestMapping("show/{id}")
    public MVCResult show(@PathVariable Integer id) {
        try {
            return MVCResult.buildTrueResult(groupService.show(id));
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping("delete/{id}")
    public MVCResult delete(@PathVariable Integer id) {
        try {
            GroupModel result = groupService.delete(id);
            return MVCResult.buildTrueResult(result);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    /**
     * 关联用户和用户组
     * 
     * @param groupId
     * @param users
     * @return
     */
    @RequestMapping("relation/user")
    public MVCResult relationUser(@RequestParam("groupid") Integer groupId,
            @RequestParam("users") List<Integer> users) {
        try {
            groupService.relationUser(groupId, users);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    /**
     * 关联用户组和资源
     * 
     * @param groupid
     * @param resources
     * @return
     */
    @RequestMapping("relation/resource")
    public MVCResult relationResource(@RequestParam("groupid") Integer groupid,
            @RequestParam("resources") List<Integer> resources) {
        try {
            groupService.relationResource(groupid, resources);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping("test")
    public MVCResult test() {
        try {
            System.out.println("test");
            System.out.println(groupService);

            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }
}
