package cn.xiuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

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
@EnableDubbo
@DubboComponentScan //推荐
public class ServiceAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppliaction.class, args);
    }

}
