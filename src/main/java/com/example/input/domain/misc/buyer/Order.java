package com.example.input.domain.misc.buyer;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;

public class Order {

	private Integer id;
	private Part part;
	private Date orderDate;
	@NotNull
	@Min(1)
	private Integer quantity;
	@NotNull
	@Min(1)
	private Integer reorder;
	private Employee employee;
	private Integer remainQuantity;
	private Integer receivingQuantity;


	public Order() {
	}

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

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getRemainQuantity() {
		return remainQuantity;
	}

	public void setRemainQuantity(Integer remainQuantity) {
		this.remainQuantity = remainQuantity;
	}

	public Integer getReceivingQuantity() {
		return receivingQuantity;
	}

	public void setReceivingQuantity(Integer receivingQuantity) {
		this.receivingQuantity = receivingQuantity;
	}

}
