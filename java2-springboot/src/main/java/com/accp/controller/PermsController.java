package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Permissions;
import com.accp.domain.Users;
import com.accp.service.PermissionsService;

@RestController
@RequestMapping("/perms")
public class PermsController {
	
	@Autowired
	PermissionsService permService;

	
	@GetMapping("/find")
	public List<Permissions> findPermssions(HttpSession sessions){
		Users user = (Users)sessions.getAttribute("user");
		return permService.findEachByUid(user.getId());
	}

	@GetMapping("/findById")
	public Permissions findById(Integer pid) {
		return permService.findById(pid);
	}
	
}
