package cn.xiuyu.web.configure;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ServletConfigure {

	/**
	 * Druid http://localhost:8090/druid/index.html
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<Servlet> testServletRegistration() {
		ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<Servlet>(new StatViewServlet());
		registration.addUrlMappings("/druid/*");
		registration.setName("druid");
		return registration;
	}
}
