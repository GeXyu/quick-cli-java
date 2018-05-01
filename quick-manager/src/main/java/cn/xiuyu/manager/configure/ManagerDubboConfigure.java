package cn.xiuyu.manager.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import cn.xiuyu.user.service.GroupService;
import cn.xiuyu.user.service.ResouceService;
import cn.xiuyu.user.service.UserService;

@Configuration
@PropertySource("classpath:dubbo-manager.properties")
public class ManagerDubboConfigure implements EnvironmentAware {

    @Autowired
    private ApplicationConfig applicationConfig; // 保存配置对象避免重复创建
    private RegistryConfig registryConfig; // 保存配置对象避免重复创建

    /**
     * @see org.springframework.context.EnvironmentAware#setEnvironment(org.springframework.core.env.Environment)
     */
    @Override
    public void setEnvironment(Environment env) {
        applicationConfig.setName("dubboConfig");
        registryConfig = new RegistryConfig(env.getProperty("dubbo.registry.address"));
    }

    @Bean
    public RegistryConfig registryConfig() {
        return registryConfig;
    }

    // -------------------
    @Bean
    public UserService userService() {
        return getReference(UserService.class);
    }

    @Bean
    public GroupService groupService() {
        return getReference(GroupService.class);
    }

    @Bean
    public ResouceService resouceService() {
        return getReference(ResouceService.class);
    }

    // -----
    /**
     * 通用获取代理对象方法
     * 
     * @param c
     * @return
     */
    private <T> T getReference(Class<T> c) {
        ReferenceConfig<T> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(c);
        return reference.get();
    }

}
