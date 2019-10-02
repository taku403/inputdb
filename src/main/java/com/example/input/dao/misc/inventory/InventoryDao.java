package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.inventory.Inventory;
import com.example.input.domain.misc.inventory.Location;

public interface InventoryDao {

	void insert(Inventory inventory) throws Exception;
	void update(Inventory inventory) throws Exception;
	void delete(Inventory inventory) throws Exception;
	Inventory findById(Integer id) throws Exception;
	List<Inventory> findAll() throws Exception;
	List<Inventory> findByLocation(Location location) throws Exception;
	Inventory findByPart(Part part) throws Exception;
	List<Inventory>findByAllParts(Part part) throws Exception;
}
