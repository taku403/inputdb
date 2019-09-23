package com.example.input.dao.misc.buyer;

import java.util.List;

import com.example.input.domain.misc.buyer.Order;

public interface OrderDao {

	void insert(Order order) throws Exception;
	void delete(Order order) throws Exception;
	void update(Order order) throws Exception;
	Order findById(Integer id) throws Exception;
	List<Order> findAll() throws Exception;
}
