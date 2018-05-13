/*
 * $Id: ResourceServiceImpl.java, 2018年4月30日 下午6:13:51 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.repository.ResourceRepository;
import cn.xiuyu.user.service.ResouceService;

/**
 * <p>
 * Title: ResourceServiceImpl
 * </p>
 * <p>
 * Description:资源服务
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午6:13:51
 * @modified [who date description]
 * @check [who date description]
 */
@Service(interfaceClass = ResouceService.class)
public class ResourceServiceImpl implements ResouceService {

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * @see cn.xiuyu.core.service.base.BaseService#save(java.lang.Object)
     */
    @Override
    public ResourceModel save(ResourceModel model) {
        return resourceRepository.save(model);
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#update(java.lang.Object)
     */
    @Override
    public ResourceModel update(ResourceModel model) {
        return save(model);
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#show(java.lang.Object)
     */
    @Override
    public ResourceModel show(Integer id) {
        Optional<ResourceModel> result = resourceRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    /**
     * @see cn.xiuyu.core.service.base.BaseService#delete(java.lang.Object)
     */
    @Override
    public ResourceModel delete(Integer id) {
        ResourceModel resource = show(id);
        if (resourceRepository != null) {
            resourceRepository.delete(resource);
        }
        return resource;
    }

    /**
     * @see cn.xiuyu.user.service.ResouceService#findTopResource()
     */
    @Override
    public List<ResourceModel> findTopResource() {
        return resourceRepository.findByParentIsNull();
    }

    /**
     * @see cn.xiuyu.user.service.ResouceService#findChildrenResource(java.lang.Integer)
     */
    @Override
    public List<ResourceModel> findChildrenResource(ResourceModel resource) {
        ResourceModel model = new ResourceModel();
        model.setParent(resource);
        return resourceRepository.findAll(Example.of(model));
    }

}
