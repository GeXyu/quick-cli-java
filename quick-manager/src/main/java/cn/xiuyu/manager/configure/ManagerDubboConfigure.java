package cn.xiuyu.manager.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dubbo-manager.properties")
public class ManagerDubboConfigure {

}
