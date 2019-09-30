package com.example.input.dao.misc.receiving;

import java.util.List;

import com.example.input.domain.misc.receiving.Reception;

public interface ReceptionDao {

	void insert(Reception recipient) throws Exception;
	void update(Reception recipient) throws Exception;
	void delete(Reception recipient) throws Exception;
	Reception findById(Integer id) throws Exception;
	List<Reception> findAll() throws Exception;
	Reception findByLoginId(String loginId) throws Exception;
}
