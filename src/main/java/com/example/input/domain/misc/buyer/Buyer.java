package com.example.input.domain.misc.buyer;

import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;

public class Buyer {

	private Integer id;
	@NotNull
	private Employee employee;

	public Buyer() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

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
