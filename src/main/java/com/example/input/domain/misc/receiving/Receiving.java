package com.example.input.domain.misc.receiving;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Order;

@Component
public class Receiving {

	private Integer id;
	@NotNull(groups = { AddGroup.class, EditGroups.class })
	private Order order;
	@Autowired
	private OrderDao orderDao;
	@Min(value = 0, groups = { AddGroup.class, EditGroups.class })
	private Integer quantity;
	private Boolean completeFlag;
	private Date created;
	private Employee employee;
	@Autowired
	private EmployeeDao employeeDao;

	public Receiving() {
		this.completeFlag = false;
	}

	/**
	 *  受け入れ完了の確認をする
	 *  param: recevingQuantity 受付入力画面から入力された数量
	 * @return 完納状態： true  分納状態：false
	 */

	public Boolean isComplete() {

		if (order != null) {

			Integer receivedQuantity = order.getReceivedQuantity() + quantity;
			if (order.getQuantity() > receivedQuantity) {

				order.setReceivedQuantity(receivedQuantity);
				completeFlag = false;
				return false;

			} else if (order.getQuantity() < receivedQuantity) {

				completeFlag = false;
				System.out.println("ERR; " + receivedQuantity + " 受け取った数量の合計値のほうが多いです");
				return false;
			} else {

				order.setReceivedQuantity(receivedQuantity);
				completeFlag = true;
				return true;
			}
		}
		else {

			System.out.println("Receiving.Order domain Object がnullです");

			return false;
		}

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

	public Boolean getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(Boolean completeFlag) {
		this.completeFlag = completeFlag;
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

	public void setOrder(Integer orderId) throws Exception {
		this.order = orderDao.findById(orderId);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(String loginId) throws Exception {
		this.employee = employeeDao.findByloginId(loginId);
	}
}