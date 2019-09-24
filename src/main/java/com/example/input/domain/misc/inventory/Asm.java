package com.example.input.domain.misc.inventory;

import com.example.input.domain.misc.admin.Part;

public abstract class Asm {

	private Integer id;
	private Part part;

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
}
