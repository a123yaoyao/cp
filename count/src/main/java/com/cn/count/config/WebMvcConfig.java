package com.cn.count.config;

import com.cn.count.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig  implements WebMvcConfigurer{

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Bean
    public LoginHandlerInterceptor userInterceptor() {
        return new LoginHandlerInterceptor();
    }

    //注意这里不要使用 new LoginHandlerInterceptor() ，否则就会出现拦截器里无法注入service的问题
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                loginHandlerInterceptor
        ).addPathPatterns("/**").excludePathPatterns("/api/getToken","/success");
    }
}

