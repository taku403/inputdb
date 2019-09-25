package com.example.input.domain.misc.inventory;

import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;

/**
 *
 * @author zd2F20
 * 分類：在庫管理
 */
public class InventoryManager {

	private Integer id;
	@NotNull
	private Employee employee;

	public InventoryManager() {
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
