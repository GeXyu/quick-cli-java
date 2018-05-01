/*
 * $Id: ManagerApplicationConfigure.java, 2018年5月1日 下午8:46:59 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.configure;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.xiuyu.manager.filter.ManagerCORSFilter;

/**
 * <p>
 * Title: ManagerApplicationConfigure
 * </p>
 * <p>
 * Description:工程配置
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午8:46:59
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
public class ManagerApplicationConfigure {

    /**
     * 跨域
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
        filterRegistrationBean.setFilter(new ManagerCORSFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;

    }

}
