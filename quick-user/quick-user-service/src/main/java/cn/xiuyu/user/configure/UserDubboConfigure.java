package cn.xiuyu.user.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource(locations = { "classpath:dubbo-user.xml" })
@PropertySource("classpath:dubbo-user.properties")
public class UserDubboConfigure {

}
