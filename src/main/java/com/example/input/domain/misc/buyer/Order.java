package com.example.input.domain.misc.buyer;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;

public class Order {

	private Integer id;
	@NotNull
	private Part part;
	private Date orderDate;
	@Min(1)
	private Integer quantity;
	@Min(1)
	private Integer reorderPoint;
	@NotNull
	private Employee employee;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
