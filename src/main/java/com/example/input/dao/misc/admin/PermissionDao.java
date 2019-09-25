package com.example.input.dao.misc.admin;

import java.util.List;

import com.example.input.domain.misc.admin.PermissionCheckboxModel;

public interface PermissionDao {

	public void insert(PermissionCheckboxModel permission) throws Exception;
	public void delete(PermissionCheckboxModel permission) throws Exception;
	public void update(PermissionCheckboxModel permission) throws Exception;
	public PermissionCheckboxModel findById(Integer id) throws Exception;
	public List<PermissionCheckboxModel> findAll() throws Exception;

}
