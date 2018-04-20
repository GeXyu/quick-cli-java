/*
 * $Id: ZookeeperTest.java, 2018年4月14日 下午9:49:36 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package org.quick.service;

import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

/**
 * <p>
 * Title: ZookeeperTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月14日 下午9:49:36
 * @modified [who date description]
 * @check [who date description]
 */
public class ZookeeperTest {

    @Test
    public void connection() {
        ZkClient zkClient = new ZkClient("192.168.1.35:2181", 5000);
        zkClient.createPersistent("/test");
        System.out.println("创建成功");
        zkClient.close();
    }

}
