package com.initcat.user_service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.alicp.jetcache.autoconfigure"})
@ComponentScan(basePackages = "com.initcat")
@EnableMethodCache(basePackages = "com.initcat.user_service.dao")
@EnableCreateCacheAnnotation
@EnableDubboConfiguration
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
