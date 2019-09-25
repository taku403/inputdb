package com.example.input.dao.misc.recipient;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.Recipient;
import com.example.input.domain.misc.admin.Employee;

@Transactional
@Repository
public class RecipientDaoImpl extends HibernateORM implements RecipientDao {

	@Override
	public void insert(Recipient recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(recipient);
	}

	@Override
	public void update(Recipient recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().update(recipient);
	}

	@Override
	public void delete(Recipient recipient) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(recipient);
	}

	@Override
	public Recipient findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Recipient)getSession().createCriteria(Recipient.class).add(Restrictions.eq("id",id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipient> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Restrictions.class).list();
	}

	@Override
	public Recipient findByEmployee(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Recipient)getSession().createCriteria(Restrictions.class).setFetchMode("employee", FetchMode.JOIN)
				.add(Restrictions.eq("employee.id", employee.getId())).uniqueResult();
	}



}