/*
 * $Id: Swagger2.java, 2018年4月30日 下午12:05:46 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Title: Swagger2
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午12:05:46
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
@EnableSwagger2
public class ManagerSwagger2 {

    private static final String VERSION = "1.0";
    private static final String BASE_PACKAGE = "cn.xiuyu.manager.controller";
    private static final String LICENSE_UI_HTML = "http://localhost:8090/swagger-ui.html";
    private static final String TITLE = "Quick-cli";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(TITLE).description(TITLE).licenseUrl(LICENSE_UI_HTML).version(VERSION)
                .build();
    }

}
