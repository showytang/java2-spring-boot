package com.accp.intercetor;

import java.lang.invoke.MethodHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.accp.controller.LoginController;
import com.accp.domain.Users;

/**
 * 拦截登录
 * @author tangyong
 *
 */
public class MyInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			if(method.getBean() instanceof LoginController) {
				return true;
			}
		}
		
		Users user = (Users)request.getSession().getAttribute("user");
		if(user!=null) {
			return true;
		}
		return false;
	}

}
