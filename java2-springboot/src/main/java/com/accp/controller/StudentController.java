package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping("/student/find")
	public String find(Model model) {
		model.addAttribute("stus", service.findByPage(1, 3, null));
		return "find";//视图
	}

}
