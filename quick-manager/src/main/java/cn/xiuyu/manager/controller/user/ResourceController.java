/*
 * $Id: ResourceController.java, 2018年4月30日 下午6:18:19 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.manager.data.MVCResult;
import cn.xiuyu.user.model.ResourceModel;
import cn.xiuyu.user.service.ResouceService;

/**
 * <p>
 * Title: ResourceController
 * </p>
 * <p>
 * Description:资源controller
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午6:18:19
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
@RequestMapping("manager/user/resource")
public class ResourceController {

    @Autowired
    private ResouceService resouceService;

    /**
     * 新增
     * 
     * @param resource
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public MVCResult save(@RequestBody ResourceModel resource) {
        try {
            resouceService.save(resource);
            return MVCResult.buildTrueResult(resource);
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    /**
     * 查看
     * 
     * @param id
     * @return
     */
    @RequestMapping("show/{id}")
    public MVCResult show(@PathVariable Integer id) {
        try {
            return MVCResult.buildTrueResult(resouceService.show(id));
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    /**
     * 删除
     * 
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public MVCResult delete(@PathVariable Integer id) {
        try {
            return MVCResult.buildTrueResult(resouceService.delete(id));
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }

    @RequestMapping("test}")
    public MVCResult test() {
        try {
            System.out.println(resouceService);
            return MVCResult.buildTrueResult();
        } catch (Exception e) {
            return MVCResult.buildFalseResult(e);
        }
    }
}
