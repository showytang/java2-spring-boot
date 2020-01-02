package com.accp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Users;
import com.accp.service.UsersService;

@RestController
public class LoginController {

	@Autowired
	UsersService service;

	@PostMapping("/loginin")
	public Map<String, Object> loginin(String username, String password, HttpSession session) {
		Users users = new Users();
		users.setUsername(username);
		users.setPassword(password);
		users = service.findByUsers(users);
		if (users == null) {
			return null;
		}
		session.setAttribute("user", users);
		Map<String, Object> map = new HashMap<>();
		map.put("user", users);
		map.put("token", session.getId());
		return map;
	}

}
