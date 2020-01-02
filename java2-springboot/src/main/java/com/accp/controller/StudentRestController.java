package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Student;
import com.accp.service.StudentService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	
	@Autowired
	StudentService service;
	
	@GetMapping
	public PageInfo<Student> find(Integer pageNum,Integer pageSize,Student stu){
		return service.findByPage(pageNum, pageSize, stu);
	}

}
