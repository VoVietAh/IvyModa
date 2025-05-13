package com.poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.poly.service.*;
import com.poly.entity.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	SessionService session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	        throws Exception {
	    
	    KhachHang user = session.get("user");
	    
	    if (user == null) {
	        String uri = request.getRequestURI();
	        if (!uri.contains("/user/login")) { // Không lưu trang login
	            session.set("securityUri", uri);
	        }
	        
	        response.sendRedirect("/user/login");
	        return false;
	    }

	    return true;
	}

	
	
	
	
}
