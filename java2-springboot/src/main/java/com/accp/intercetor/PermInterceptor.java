package com.accp.intercetor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.accp.domain.Permissions;
import com.accp.domain.Users;
import com.accp.service.PermissionsService;

@Component
public class PermInterceptor implements HandlerInterceptor {

	
	@Autowired
	PermissionsService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Users user = (Users)request.getSession().getAttribute("user");
		List<Permissions> perms = service.findByUid(user.getId());
		String path = request.getRequestURI();
		boolean bol = perms.stream().anyMatch(item->item.getPath()!=null && item.getPath().indexOf(path)!=-1);
		return bol;
	}
	
}
