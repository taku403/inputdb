package com.example.input.domain.misc.admin;


import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.AddGroup;
import com.example.input.domain.EditGroups;
import com.example.input.domain.misc.buyer.Supplier;

public class Part {

	private Integer id;
	private String productNo;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	private String name;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	@Min(1)
	private Integer price;
	@NotBlank(groups= {AddGroup.class,EditGroups.class})
	@Min(1)
	private Integer lot;
	private Date registerd;
	private Date update;
	private Supplier supplier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getLot() {
		return lot;
	}

	public void setLot(Integer lot) {
		this.lot = lot;
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

	public void setUpdate(Date updated) {
		this.update = updated;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
