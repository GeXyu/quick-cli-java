/*
 * $Id: ShiroConfigure.java, 2018年5月1日 上午11:24:38 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.configure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.xiuyu.manager.filter.StatelessAccessControlFilter;
import cn.xiuyu.manager.shiro.StatelessAuthorizingRealm;
import cn.xiuyu.manager.shiro.StatelessDefaultSubjectFactory;

/**
 * <p>
 * Title: ShiroConfigure
 * </p>
 * <p>
 * Description:shiro 配置类
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 上午11:24:38
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
public class ManagerShiroConfigure {

    @Autowired
    private StatelessAuthorizingRealm statelessAuthorizingRealm;

    @Autowired
    private StatelessAccessControlFilter statelessAccessControlFilter;

    /**
     * 配置过滤器工厂
     * 
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFacotryBean = new ShiroFilterFactoryBean();
        filterFacotryBean.setSecurityManager(securityManager);

        // 设置filter

        // 配置过滤url
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //
        filterChainDefinitionMap.put(" */swagger-ui.html*", "anon");
        filterChainDefinitionMap.put(" */manager/stateless/login*", "anon");
        filterChainDefinitionMap.put("/**", "statelessAuthc");

        filterFacotryBean.setLoginUrl("*/manager/stateless/login*");
        filterFacotryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        filterFacotryBean.getFilters().put("statelessAuthc", statelessAccessControlFilter);
        return filterFacotryBean;
    }

    /**
     * shiro安全管理器: 主要是身份认证的管理，缓存管理，cookie管理
     * 
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setSubjectFactory(new StatelessDefaultSubjectFactory());

        /**
         * 禁用使用Sessions 作为存储策略的实现，但它没有完全地禁用Sessions
         * 所以需要配合context.setSessionCreationEnabled(false);
         */
        DefaultSessionStorageEvaluator storageEvaluator = ((DefaultSessionStorageEvaluator) ((DefaultSubjectDAO) securityManager
                .getSubjectDAO()).getSessionStorageEvaluator());
        storageEvaluator.setSessionStorageEnabled(false);

        // relames 配置realms
        List<Realm> realms = new ArrayList<>();
        realms.add(statelessAuthorizingRealm);
        securityManager.setRealms(realms);
        return securityManager;
    }

    /**
     * session管理器，禁用session
     * 
     * @return
     */
    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setDeleteInvalidSessions(false);
        return sessionManager;
    }

    // 解决shiro注释不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    @ConditionalOnMissingBean // 如果没有就加入
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

}
