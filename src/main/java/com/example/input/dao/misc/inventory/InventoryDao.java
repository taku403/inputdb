package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.inventory.Inventory;

public interface InventoryDao {

	void insert(Inventory inventory) throws Exception;
	void update(Inventory inventory) throws Exception;
	void delete(Inventory inventory) throws Exception;
	Inventory findById(Integer id) throws Exception;
	List<Inventory> findAll() throws Exception;
}
