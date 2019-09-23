package com.example.input.dao.misc.buyer;

import java.util.List;

import com.example.input.domain.misc.buyer.Supplier;

public interface SupplierDao {

	void insert(Supplier supplier) throws Exception;
	void delete(Supplier supplier) throws Exception;
	void update(Supplier supplier) throws Exception;
	Supplier findById(Integer id) throws Exception;
	List<Supplier> findAll() throws Exception;
}