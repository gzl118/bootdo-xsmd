package com.bootdo.system.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
public class CommonConfiguration implements WebMvcConfigurer{
	
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // 多个拦截器组成一个拦截器链
	        // addPathPatterns 用于添加拦截规则
	        // excludePathPatterns 用户排除拦截
	        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
	    }
	
}
