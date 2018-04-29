package cn.xiuyu.web.configure;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.WebStatFilter;

import cn.xiuyu.web.filter.CrossOriginFIlter;

@Configuration
public class FilterConfigure {

    /**
     * 跨域
     * 
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> configFilter() {

        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setFilter(new CrossOriginFIlter());
        registration.setName("CrossOrigin");
        registration.addUrlPatterns("/*");

        return registration;
    }

    /**
     * Druid
     * 
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> druidConfigFilter() {

        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setFilter(new WebStatFilter());
        registration.setName("druid");
        registration.addUrlPatterns("/*");

        // 忽略资源
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        registration.setInitParameters(initParameters);

        return registration;
    }
}
