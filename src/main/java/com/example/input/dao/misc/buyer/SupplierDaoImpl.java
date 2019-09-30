package com.example.input.dao.misc.buyer;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.buyer.Supplier;

@Transactional
@Repository
public class SupplierDaoImpl extends HibernateORM implements SupplierDao {

	@Override
	public void insert(Supplier supplier) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		supplier.setCreated(new Date());
		getSession().save(supplier);
	}

	@Override
	public void delete(Supplier supplier) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(supplier);
	}

	@Override
	public void update(Supplier supplier) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(supplier);
	}

	@Override
	public Supplier findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Supplier)getSession().createCriteria(Supplier.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Supplier.class).list();
	}

}
