package cn.xiuyu.user.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dubbo-user.properties")
public class UserDubboConfigure {

}
