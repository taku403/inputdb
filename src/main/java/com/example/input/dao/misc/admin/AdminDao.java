package com.example.input.dao.misc.admin;

import java.util.List;

import com.example.input.domain.misc.admin.Admin;
import com.example.input.domain.misc.admin.Employee;

public interface AdminDao {

	public void insert(Admin admin) throws Exception;
	public void update(Admin admin) throws Exception;
	public void delete(Admin admin) throws Exception;
	public Admin findById(Integer id) throws Exception;
	public List<Admin> findAll() throws Exception;
	public Admin findByEmployee(Employee employee) throws Exception;

}
