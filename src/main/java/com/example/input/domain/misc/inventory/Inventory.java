package com.example.input.domain.misc.inventory;

import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;
import com.example.input.domain.misc.admin.Part;

public class Inventory {

	private Integer id;
	private Part part;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	@Min(0)
	private Integer amount;
	private Location location;
	private Date updated;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}