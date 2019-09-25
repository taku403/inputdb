package com.example.input.dao.misc.recipient;

import java.util.List;

import com.example.input.domain.misc.Recipient;
import com.example.input.domain.misc.admin.Employee;

public interface RecipientDao {

	void insert(Recipient recipient) throws Exception;
	void update(Recipient recipient) throws Exception;
	void delete(Recipient recipient) throws Exception;
	Recipient findById(Integer id) throws Exception;
	List<Recipient> findAll() throws Exception;
	Recipient findByEmployee(Employee employee) throws Exception;
}
