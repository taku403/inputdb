package com.example.input.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.misc.admin.Employee;

@Repository
public abstract class Init {


	@Autowired
	EmployeeDao employeeDao;
	@InitBinder
	public void Binder(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	public Employee getByEmployee(String loginId) throws Exception {


		Employee employee = employeeDao.findByloginId(loginId);
		return employee;
	}
}
