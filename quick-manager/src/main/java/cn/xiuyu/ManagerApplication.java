/*
 * $Id: ManagerApplication.java, 2018年4月29日 下午9:55:33 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * <p>
 * Title: ManagerApplication
 * </p>
 * <p>
 * Description:manager启动类
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月29日 下午9:55:33
 * @modified [who date description]
 * @check [who date description]
 */
@SpringBootApplication
@EnableDubbo
@DubboComponentScan
@PropertySource("classpath:application-manager.properties")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
