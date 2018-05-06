/*
 * $Id: TestApplication.java, 2018年5月6日 下午9:10:24 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiuyu.CoreAppliaction;

/**
 * <p>
 * Title: TestApplication
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午9:10:24
 * @modified [who date description]
 * @check [who date description]
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CoreAppliaction.class })
public class CoreApplicationTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void test() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
