package com.example.input.domain.misc.receiving;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Order;

public class Receiving {

	private Integer id;
	@NotNull(groups= {AddGroup.class,EditGroups.class})
	private Order order;
	@Min(value=0,groups={AddGroup.class,EditGroups.class})
	private Integer quantity;
	private String complete;
	private Date created;
	private Employee employee;


	public Receiving() {
		this.complete = "off";
		this.created = new Date();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}