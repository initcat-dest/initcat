package com.initcat.user_service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.alicp.jetcache.autoconfigure"})
@ComponentScan(basePackages = "com.initcat")
@EnableMethodCache(basePackages = "com.initcat.user_service.dao")
@EnableCreateCacheAnnotation
@EnableDubboConfiguration
public class UserServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UserServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
