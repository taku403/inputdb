package com.example.input.dao.misc.buyer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Buyer;

@Transactional
@Repository
public class BuyerDaoImpl extends HibernateORM implements BuyerDao {

	public BuyerDaoImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void inesrt(Buyer buyer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(buyer);

	}

	@Override
	public void delete(Buyer buyer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(buyer);
	}

	@Override
	public void update(Buyer buyer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().update(buyer);
	}

	@Override
	public Buyer findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		return (Buyer)getSession().createCriteria(Buyer.class)
				.setFetchMode("employee", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Buyer> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Buyer.class).setFetchMode("employee", FetchMode.JOIN).list();
	}

	@Override
	public Buyer findByEmployee(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Buyer)getSession().createCriteria(Buyer.class)
				.setFetchMode("employee", FetchMode.JOIN).add(Restrictions.eq("employee.id", employee.getId()))
				.uniqueResult();
	}
}
