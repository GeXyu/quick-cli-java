package cn.xiuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * <p>
 * Title: ServiceAppliaction
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月14日 上午10:24:14
 * @modified [who date description]
 * @check [who date description]
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableCaching
public class ServiceAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppliaction.class, args);
    }

}
