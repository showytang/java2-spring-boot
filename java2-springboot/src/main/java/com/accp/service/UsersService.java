package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Users;
import com.accp.domain.UsersExample;
import com.accp.mapper.UsersMapper;

@Service
@Transactional
public class UsersService {

	@Autowired
	UsersMapper usersMapper;

	public Users findByUsers(Users users) {
		UsersExample ex = new UsersExample();
		ex.createCriteria().andUsernameEqualTo(users.getUsername()).andPasswordEqualTo(users.getPassword());
		List<Users> list = usersMapper.selectByExample(ex);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
