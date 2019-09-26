package com.example.input.domain.misc.inventory;

import com.example.input.domain.misc.admin.Part;

public class Inventory {

	private Integer id;
	private Part part;
	private Integer acutual;
	private Location location;
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
	public Integer getAcutual() {
		return acutual;
	}
	public void setAcutual(Integer acutual) {
		this.acutual = acutual;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}



}
