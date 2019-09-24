package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.domain.misc.inventory.Asm;


public interface AsmDao {

	void insert(Asm asm) throws Exception;
	void update(Asm asm) throws Exception;
	void delete(Asm asm) throws Exception;
	Asm findById(Integer id) throws Exception;
	List<Asm> findAll() throws Exception;
}
