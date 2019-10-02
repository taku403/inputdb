package com.example.input.dao.misc.admin;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Supplier;

@Transactional
@Repository
public class PartDaoImpl extends HibernateORM implements PartDao {

	@Override
	public void insert(Part part) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("call part insert ");
		part.setRegisterd(new Date());
		part.setUpdate(new Date());
		getSession().save(part);
	}

	@Override
	public void delete(Part part) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(part);
	}

	@Override
	public void update(Part part) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		part.setUpdate(new Date());
		getSession().update(part);
	}

	@Override
	public Part findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Part)getSession().createCriteria(Part.class)
				.setFetchMode("supplier", FetchMode.JOIN)
				.setFetchMode("location", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Part> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Part.class)
				.setFetchMode("supplier", FetchMode.JOIN)
				.setFetchMode("location", FetchMode.JOIN)
				.list();
	}
	@SuppressWarnings("unchecked")
	public List<Part> findAllSuppliers(Supplier supplier) throws Exception {

		return getSession().createCriteria(Part.class)
			.setFetchMode("supplier", FetchMode.JOIN)
				.setFetchMode("location", FetchMode.JOIN)
				.add(Restrictions.eq("supplier", supplier))
				.list();
	}
}
