package com.poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	AuthInterceptor authInterceptor;
	// chặn các url liên quan đến trang admin, và giỏ hàng -> đăng nhập thì được add sp vào giỏ hàng
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(authInterceptor)
	
		.addPathPatterns("home/admin/**","/home/cart/**");
	}
}
