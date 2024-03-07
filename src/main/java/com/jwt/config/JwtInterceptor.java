package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwt.exception.AccessDeniedException;
import com.jwt.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//incoming request
		String token=request.getHeader("token");
		
		//outgoing request
		/*
		 * if(token!=null && !token.isEmpty()) { response.addHeader("token", token); }
		 */
		
		if(!(request.getRequestURI().contains("signup") || request.getRequestURI().contains("login"))) {
			jwtUtils.verify(token);
		}
		
		
		return true;
	}
	


}
