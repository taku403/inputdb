package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.inventory.LocationPart;


public interface LocationPartDao {

	void insert(LocationPart locationPart) throws Exception;
	void update(LocationPart locationPart) throws Exception;
	void delete(LocationPart locationPart) throws Exception;
	LocationPart findById(Integer id) throws Exception;
	List<LocationPart> findAll() throws Exception;
}
