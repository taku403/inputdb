package com.example.input.domain.misc.receiving;

import java.util.Date;

import javax.validation.constraints.Min;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Order;

public class Receiving {

	private Integer id;
	private Order order;
	private Part part;
	@Min(value=0,groups={AddGroup.class,EditGroups.class})
	private Integer quantity;
	private QuantityType quantityType;
	private Date receptionDay;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public QuantityType getQuantityType() {
		return quantityType;
	}
	public void setQuantityType(QuantityType quantityType) {
		this.quantityType = quantityType;
	}
	public Date getReceptionDay() {
		return receptionDay;
	}
	public void setReceptionDay(Date receptionDay) {
		this.receptionDay = receptionDay;
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