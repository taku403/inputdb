package com.example.input.domain.misc.buyer;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;

@Component
public class Order {

	private Integer id;
	private Part part;
	@Autowired
	private PartDao partDao;
	private Date orderDate;
	@NotNull
	@Min(1)
	private Integer quantity;
	private Integer completeFlag;
	private Integer reorder;
	private Employee employee;
	@Autowired
	private EmployeeDao employeeDao;
	private Integer receivedQuantity;

	public Order() {
		this.completeFlag = 0;
		employee = new Employee();
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

	public void setPart(Integer partId) throws Exception {

		part = partDao.findById(partId);
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

	public void setEmployee(String loginId) throws Exception {

		employee = employeeDao.findByloginId(loginId);
	}

	public Integer getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Integer receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public Integer getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(Integer completeFlag) {
		this.completeFlag = completeFlag;
	}
}
