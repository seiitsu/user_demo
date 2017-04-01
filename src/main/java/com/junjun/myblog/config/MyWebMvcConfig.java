package com.junjun.myblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.junjun.myblog.interceptor.UserLoginInterceptor;

/**
 * 自定义的一个MVC配置类
 * 
 * @author jun
 *
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("loginForm");
		registry.addViewController("/regist").setViewName("registForm");
		registry.addViewController("/addUser").setViewName("user/addUserForm");
		registry.addViewController("/user/toFindUserForm").setViewName("user/findUserForm");
		registry.addViewController("/toUploadFileForm").setViewName("user/uploadFileForm");
	}

	/* 
	 * 用户登陆的拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**");
	}

}
