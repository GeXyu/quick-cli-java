/*
 * $Id: QuickUserServiceTest.java, 2018年5月1日 下午5:31:15 XiuYu.Ge Exp $
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

/**
 * <p>
 * Title: QuickUserServiceTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午5:31:15
 * @modified [who date description]
 * @check [who date description]
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ServiceAppliaction.class })
public class QuickUserServiceTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testBeanDefinitionList() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
