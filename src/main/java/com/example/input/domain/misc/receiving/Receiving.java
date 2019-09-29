package com.example.input.domain.misc.receiving;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;

public class Receiving {

	private Integer id;
	@NotNull
	private Part part;
	@Min(1)
	private Integer quantity;
	@NotNull
	private QuantityType quantityType;
	private Date receptionDay;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getReceptionDay() {
		return receptionDay;
	}
	public void setReceptionDay(Date receptionDay) {
		this.receptionDay = receptionDay;
	}
}