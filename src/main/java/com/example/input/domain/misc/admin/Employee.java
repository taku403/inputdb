package com.example.input.domain.misc.admin;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.LoginGroup;

public class Employee {

	private Integer id;
	@NotBlank(groups= {AddGroup.class})
	private String name;
	@NotNull(groups= {AddGroup.class})
	private Department department;
	private String phone;
	@NotBlank(groups= {AddGroup.class})
	@NotNull
	private String address;
	private String note;
	@NotBlank(groups= {AddGroup.class,LoginGroup.class})
	private String loginPass;
	@NotBlank(groups= {AddGroup.class, LoginGroup.class})
	private String loginId;
	private boolean admin;
	private boolean buyer;
	private boolean reception;
	private boolean inventory;
	private Date registerd;
	private Date update;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isBuyer() {
		return buyer;
	}

	public void setBuyer(boolean buyer) {
		this.buyer = buyer;
	}

	public boolean isReception() {
		return reception;
	}

	public void setReception(boolean reception) {
		this.reception = reception;
	}

	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}

	public Date getRegisterd() {
		return registerd;
	}

	public void setRegisterd(Date registerd) {
		this.registerd = registerd;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}


}
