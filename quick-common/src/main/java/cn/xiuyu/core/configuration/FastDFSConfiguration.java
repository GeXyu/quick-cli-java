/*
 * $Id: FastDFSConfiguration.java, 2018年5月6日 下午6:02:44 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import cn.xiuyu.core.fastdfs.pool.AbstractFastDFSPool;
import cn.xiuyu.core.fastdfs.pool.FastDFSPool;

/**
 * <p>
 * Title: FastDFSConfiguration
 * </p>
 * <p>
 * Description:fastDfS配置
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午6:02:44
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
@Component
public class FastDFSConfiguration {

    @Bean
    public FastDFSPool getFastDFSPool() {
        return new AbstractFastDFSPool();
    }
}
