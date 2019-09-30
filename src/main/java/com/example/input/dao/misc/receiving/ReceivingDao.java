package com.example.input.dao.misc.receiving;

import java.util.List;

import com.example.input.domain.misc.receiving.Receiving;

public interface ReceivingDao {

	void insert(Receiving receiving) throws Exception;
	void update(Receiving receiving) throws Exception;
	void delete(Receiving receiving) throws Exception;
	Receiving findById(Integer id) throws Exception;
	List<Receiving> findAll() throws Exception;

}
