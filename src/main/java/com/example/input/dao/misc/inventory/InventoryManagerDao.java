package com.example.input.dao.misc.inventoryManager;

import java.util.List;

import com.example.input.domain.misc.InventoryManager;
import com.example.input.domain.misc.admin.Employee;

public interface InventoryManagerDao {

	public void insert(InventoryManager manager) throws Exception;
	public void delete(InventoryManager manager) throws Exception;
	public void update(InventoryManager manager) throws Exception;
	public InventoryManager findById(Integer id) throws Exception;
	public List<InventoryManager> findAll() throws Exception;
	public InventoryManager findByEmployee(Employee employee) throws Exception;
}
