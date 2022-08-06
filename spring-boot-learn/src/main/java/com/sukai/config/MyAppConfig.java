package com.sukai.config;

import com.sukai.web.LoginInterceptor;
import com.sukai.web.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * @author chengsukai
 * @since 2022-07-11 09:47
 */

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    // 添加拦截器对象注入到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 创建拦截器对象
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        String[] path = {"/user/**"};
        String[] excludePath = {"/user/login"};
        registry.addInterceptor(loginInterceptor).addPathPatterns(path).excludePathPatterns(excludePath);
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Collections.singleton("/user/*"));
        return bean;
    }
}
