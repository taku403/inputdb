package com.example.input.dao.misc.receiving;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.receiving.Reception;

@Transactional
@Repository
public class ReceptionDaoImpl extends HibernateORM implements ReceptionDao {

	@Override
	public void insert(Reception recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(recipient);
	}

	@Override
	public void update(Reception recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().update(recipient);
	}

	@Override
	public void delete(Reception recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(recipient);
	}

	@Override
	public Reception findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Reception)getSession().createCriteria(Reception.class).add(Restrictions.eq("id",id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reception> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Restrictions.class).list();
	}

	@Override
	public Reception findByEmployee(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Reception)getSession().createCriteria(Reception.class).setFetchMode("employee", FetchMode.JOIN)
				.add(Restrictions.eq("employee.id", employee.getId())).uniqueResult();
	}



}