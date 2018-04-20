package cn.xiuyu.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("dubbo-user-service.properties")
public class DubboConfigure {

}
