package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class Permissions {
	private Integer id;

	private String name;

	private String ename;

	private Integer catalog;

	private Integer parentid;

	private String path;

	private List<Permissions> childrens = new ArrayList<Permissions>();

	public void setChildrens(List<Permissions> childrens) {
		this.childrens = childrens;
	}

	public List<Permissions> getChildrens() {
		return childrens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}