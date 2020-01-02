package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Student;
import com.accp.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	StudentMapper stuMapper;
	
	
	public PageInfo<Student> findByPage(Integer pageNum,Integer pageSize,Student stu){
		Page<Student> page = PageHelper.startPage(pageNum, pageSize);
		stuMapper.selectByExample(null);
		return page.toPageInfo();
	}
	
}
