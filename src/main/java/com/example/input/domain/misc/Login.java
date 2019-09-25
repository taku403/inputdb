package com.example.input.domain.misc;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.LoginGroup;

public abstract class Login {

	@NotBlank(groups = {AddGroup.class, LoginGroup.class})
	private String name;
	@NotBlank(groups = {AddGroup.class, LoginGroup.class})
	private String pass;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}