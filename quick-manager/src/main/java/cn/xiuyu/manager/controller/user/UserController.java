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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.core.util.MD5Utils;
import cn.xiuyu.manager.data.MVCResult;
import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.model.UserModel;
import cn.xiuyu.user.service.GroupService;
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
@RequestMapping("manager/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    /**
     * 保存
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public MVCResult save(@RequestBody UserModel user) {
        try {
            System.out.println(userService);
            user.setPassword(MD5Utils.encrypt(user.getPassword()));
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

    /**
     * 获取路由
     * 
     * @param username
     * @return
     */
    @RequestMapping(value = "getRouter")
    public MVCResult getRouter(@RequestParam("username") String username) {

        try {
            UserModel user = userService.findByUsername(username);
            List<GroupModel> groupSet = user.getGroupList();

            // 去重
            List<Object> result = new ArrayList<>();
            Set<ResourceModel> topResourceSet = new HashSet<>();
            groupSet.stream().forEach(group -> {
                Map<String, Object> resourceMap = new HashMap<>();
                List<ResourceModel> topResourceList = groupService.findTopReourceByGroup(group.getId());
                topResourceList.stream().forEach(topResource -> {
                    if (!topResourceSet.contains(topResource)) {
                        topResourceSet.add(topResource);
                        List<ResourceModel> childResource = groupService.findByParentAndGroup(topResource.getId(),
                                group.getId());

                        resourceMap.put("topResource", topResource);
                        resourceMap.put("childResource", childResource);
                    }

                    result.add(resourceMap);
                });
            });
            return MVCResult.buildTrueResult(result);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping("test")
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
