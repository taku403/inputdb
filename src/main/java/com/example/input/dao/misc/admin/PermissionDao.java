package com.example.input.dao.misc.admin;

import java.util.List;

import com.example.input.domain.misc.admin.Permission;

public interface PermissionDao {

	public void insert(Permission permission) throws Exception;
	public void delete(Permission permission) throws Exception;
	public void update(Permission permission) throws Exception;
	public Permission findById(Integer id) throws Exception;
	public List<Permission> findAll() throws Exception;

}
