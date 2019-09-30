package com.example.input.dao.misc.receiving;

import java.util.List;

import com.example.input.domain.misc.receiving.QuantityType;

public interface QuantityTypeDao {

	void insert(QuantityType quantityType) throws Exception;
	void update(QuantityType quantityType) throws Exception;
	void delete(QuantityType quantityType) throws Exception;
	QuantityType findById(Integer id) throws Exception;
	List<QuantityType> findAll() throws Exception;

}
