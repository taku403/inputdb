package com.example.input.domain.misc.admin;

import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.Login;

/**
 *
 * @author Takurou Nakada
 * 管理者の情報のドメインオブジェクト
 */
public class Admin extends Login {

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
