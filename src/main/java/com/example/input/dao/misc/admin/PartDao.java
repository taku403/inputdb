package com.example.input.dao.misc.admin;

import java.util.List;

import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Supplier;

public interface PartDao {

	void insert(Part part) throws Exception;
	void delete(Part part) throws Exception;
	void update(Part part) throws Exception;
	Part findById(Integer id) throws Exception;
	List<Part> findAll() throws Exception;
	List<Part> findAllSuppliers(Supplier supplier) throws Exception;
}
