package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.inventory.Location;

public interface LocationDao {

	void insert(Location location) throws Exception;
	void update(Location location) throws Exception;
	void delete(Location location) throws Exception;
	Location findById(Integer id) throws Exception;
	List<Location> findAll() throws Exception;
}
