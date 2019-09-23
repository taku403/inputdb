package com.example.input.domain.misc.buyer;

import org.hibernate.validator.constraints.NotBlank;

public class Supplier {

	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
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

}
