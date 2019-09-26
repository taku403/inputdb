package com.example.input.domain.misc.admin;

/**
 * 権限付与のチェックボックスモデル
 * @author takurou
 *
 */
public class Permission {

	private Integer id;
	private boolean admin;
	private boolean buyer;
	private boolean reception;
	private boolean inventory;

	public Permission() {
		this.admin = true;
		this.buyer = true;
		this.reception = true;
		this.inventory = true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isBuyer() {
		return buyer;
	}

	public void setBuyer(boolean buyer) {
		this.buyer = buyer;
	}

	public boolean isReception() {
		return reception;
	}

	public void setReception(boolean reception) {
		this.reception = reception;
	}

	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}
}