package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.inventory.Stock;

public interface StockDao {
	void insert(Stock stock) throws Exception;
	void update(Stock stock) throws Exception;
	void delete(Stock stock) throws Exception;
	Stock findById(Integer id) throws Exception;
	List<Stock> findAll() throws Exception;
}
