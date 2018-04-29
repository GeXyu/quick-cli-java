package cn.xiuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
public class WebAppliction {
	public static void main(String[] args) {
		SpringApplication.run(WebAppliction.class, args);
	}
}
