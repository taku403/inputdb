package com.example.input.domain.misc.admin;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.example.input.domain.misc.buyer.Supplier;

public class Part {

	private Integer id;
	private String productNo;
	@NotBlank
	private String name;
	@Min(1)
	private Integer price;
	@Min(1)
	private Integer lot;
	private Date registerd;
	private Date update;
	@NotNull
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
