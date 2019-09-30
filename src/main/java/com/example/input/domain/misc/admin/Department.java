package com.example.input.domain.misc.admin;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;

public class Department {

	private Integer id;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	private String name;

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
