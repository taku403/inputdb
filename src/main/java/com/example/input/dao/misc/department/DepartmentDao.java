package com.example.input.dao.misc.department;

import java.util.List;

import com.example.input.domain.misc.admin.Department;

public interface DepartmentDao {

	void insert(Department department) throws Exception;
	void delete(Department department) throws Exception;
	void update(Department department) throws Exception;
	Department findById(Integer id) throws Exception;
	List<Department> findAll() throws Exception;
}
