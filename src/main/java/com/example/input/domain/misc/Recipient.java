package com.example.input.domain.misc;

import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;

public class Recipient {

	private Integer id;
	@NotNull
	private Employee employee;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
