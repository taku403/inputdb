package com.example.input.dao.misc.buyer;

import java.util.List;

import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Buyer;

public interface BuyerDao {

	public void inesrt(Buyer buyer) throws Exception;
	public void delete(Buyer buyer) throws Exception;
	public void update(Buyer buyer) throws Exception;
	public Buyer findById(Integer id) throws Exception;
	public List<Buyer> findAll() throws Exception;
	public Buyer findByEmployee(Employee employee) throws Exception;
}
