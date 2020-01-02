package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Permissions;
import com.accp.mapper.PermissionsMapper;

@Service
@Transactional
public class PermissionsService {

	@Autowired
	PermissionsMapper permMapper;
	
	/**
	 * 根据用户编号获取所有权限内容,并且迭代递归成树形结构
	 * @param uid 用户编号
	 * @return
	 */
	public List<Permissions> findEachByUid(Integer uid){
		List<Permissions> lists = permMapper.findByUid(uid);
		Permissions parentPerms = new Permissions();
		parentPerms.setId(0);
		each(parentPerms, lists);
		return parentPerms.getChildrens();
	}
	
	/**
	 * 根据用户编号获取所有权限内容
	 * @param uid 用户编号
	 * @return
	 */
	public List<Permissions> findByUid(Integer uid){
		List<Permissions> lists = permMapper.findByUid(uid);
		return lists;
	}
	
	public Permissions findById(Integer pid) {
		return permMapper.selectByPrimaryKey(pid);
	}
	
	/**
	 * 递归将权限变成树形结构
	 * @param parentPerms 上层对象
	 * @param perms 需要遍历的权限
	 */
	public void each(Permissions parentPerms,List<Permissions> perms){
		for(Permissions p : perms) {
			if(p.getParentid() == parentPerms.getId()) {
				Permissions newPerms = new Permissions();
				newPerms.setId(p.getId());
				newPerms.setCatalog(p.getCatalog());
				newPerms.setEname(p.getEname());
				newPerms.setName(p.getName());
				newPerms.setParentid(p.getParentid());
				newPerms.setPath(p.getPath());
				parentPerms.getChildrens().add(newPerms);
				each(newPerms,perms);
			}
		}
	}
	
}
