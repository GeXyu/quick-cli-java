/*
 * $Id: GroupServiceImpl.java, 2018年4月30日 下午2:10:19 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.user.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xiuyu.user.model.GroupModel;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.model.UserModel;
import cn.xiuyu.user.repository.GroupRepository;
import cn.xiuyu.user.repository.ResourceRepository;
import cn.xiuyu.user.repository.UserRepository;
import cn.xiuyu.user.service.GroupService;

/**
 * <p>
 * Title: GroupServiceImpl
 * </p>
 * <p>
 * Description:用戶組
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午2:10:19
 * @modified [who date description]
 * @check [who date description]
 */
@Service(interfaceClass = GroupService.class)
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * @see cn.xiuyu.core.service.base.BaseService#save(java.lang.Object)
     */
    @Override
    public GroupModel save(GroupModel model) {
        return groupRepository.save(model);
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#update(java.lang.Object)
     */
    @Override
    public GroupModel update(GroupModel model) {
        return save(model);
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#show(java.lang.Object)
     */
    @Override
    public GroupModel show(Integer id) {
        Optional<GroupModel> result = groupRepository.findById(id);
        GroupModel group = null;
        if (result.isPresent()) {
            group = result.get();
            group.setResourceSet(new HashSet<>());
            group.setUserSet(new HashSet<>());
        }
        return group;
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#delete(java.lang.Object)
     */
    @Override
    public GroupModel delete(Integer id) {
        GroupModel group = show(id);
        if (group != null) {
            groupRepository.deleteById(id);
        }
        return group;
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#list()
     */
    @Override
    public Page<GroupModel> list(Integer currPage, Integer pageSize) {
        return groupRepository.findAll(PageRequest.of(currPage, pageSize));
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#findAll(java.lang.Integer)
     */
    @Override
    public GroupModel findAll(Integer id) {
        Optional<GroupModel> result = groupRepository.findById(id);
        GroupModel group = null;
        if (result.isPresent()) {
            group = result.get();
            group.setUserList(new ArrayList<>(group.getUserSet()));
            group.setResourceList(new ArrayList<>(group.getResourceSet()));

            group.setResourceSet(new HashSet<>());
            group.setUserSet(new HashSet<>());
        }
        return group;
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#findUser(java.lang.Integer)
     */
    @Override
    public List<UserModel> findUser(Integer id) {
        Optional<GroupModel> result = groupRepository.findById(id);
        if (result.isPresent()) {
            return new ArrayList<>(result.get().getUserSet());
        }
        return new ArrayList<>();
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#findResouce(java.lang.Integer)
     */
    @Override
    public List<ResourceModel> findResouce(Integer id) {
        Optional<GroupModel> result = groupRepository.findById(id);
        if (result.isPresent()) {
            return new ArrayList<>(result.get().getResourceSet());
        }
        return new ArrayList<>();
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#relationUser(java.lang.Integer,
     *      java.util.List)
     */
    @Override
    public void relationUser(Integer groupid, List<Integer> users) {
        Optional<GroupModel> result = groupRepository.findById(groupid);
        if (result.isPresent()) {
            GroupModel group = result.get();
            Set<UserModel> userSet = new HashSet<>();
            users.stream().forEach(userid -> {
                final Optional<UserModel> userResult = userRepository.findById(userid);
                if (userResult.isPresent()) {
                    userSet.add(userResult.get());
                }
            });

            group.setUserSet(userSet);
            groupRepository.save(group);
        }
    }

    /**
     * @see cn.xiuyu.user.service.GroupService#relationResource(java.lang.Integer,
     *      java.util.List)
     */
    @Override
    public void relationResource(@RequestParam("groupid") Integer groupid,
            @RequestParam("resources") List<Integer> resources) {
        Optional<GroupModel> result = groupRepository.findById(groupid);
        if (result.isPresent()) {
            GroupModel group = result.get();
            Set<ResourceModel> resourceSet = new HashSet<>();
            resources.stream().forEach(resourceId -> {
                final Optional<ResourceModel> resourceResult = resourceRepository.findById(resourceId);
                if (resourceResult.isPresent()) {
                    resourceSet.add(resourceResult.get());
                }
            });

            group.setResourceSet(resourceSet);
            groupRepository.save(group);
        }
    }

}
