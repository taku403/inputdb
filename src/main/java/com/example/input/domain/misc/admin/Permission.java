package com.example.input.domain.misc.admin;

import org.hibernate.validator.constraints.NotBlank;

public class Permission {

	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String group;

	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
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



}
