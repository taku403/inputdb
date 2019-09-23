package com.example.input.dao.misc.employee;

import java.util.List;

import com.example.input.domain.misc.admin.Employee;

public interface EmployeeDao {

	public void insert(Employee employee) throws Exception;
	public void delete(Employee employee) throws Exception;
	public void update(Employee employee) throws Exception;
	public Employee findById(Integer id) throws Exception;
	public List<Employee> findAll() throws Exception;
	public Employee findByLoginIdandLoginPass(String loginId) throws Exception;
}
