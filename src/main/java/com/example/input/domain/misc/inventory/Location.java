package com.example.input.domain.misc.inventory;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;

public class Location {

	private Integer id;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	private String name;
	private String note;

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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}