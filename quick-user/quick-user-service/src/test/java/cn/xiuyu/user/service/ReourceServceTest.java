/*
 * $Id: ReourceServceTest.java, 2018年5月13日 上午11:23:21 XiuYu.Ge Exp $
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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiuyu.QuickUserServiceTest;
import cn.xiuyu.user.model.ResourceModel;

/**
 * <p>
 * Title: ReourceServceTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月13日 上午11:23:21
 * @modified [who date description]
 * @check [who date description]
 */
public class ReourceServceTest extends QuickUserServiceTest {

    @Autowired
    private ResouceService reourceServce;

    @Test
    public void testFindTopResource() {
        List<ResourceModel> topList = reourceServce.findTopResource();
        topList.stream().forEach(resource -> {
            System.out.println(resource.getName());
        });
    }

}
