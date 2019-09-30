package com.example.input.dao.misc.receiving;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.receiving.Receiving;

@Transactional
@Repository
public class ReceivingDaoImpl extends HibernateORM implements ReceivingDao {

	@Override
	public void insert(Receiving receiving) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		receiving.setReceptionDay(new Date());
		getSession().save(receiving);

	}

	@Override
	public void update(Receiving receiving) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		receiving.setReceptionDay(new Date());
		getSession().update(receiving);
	}

	@Override
	public void delete(Receiving receiving) throws Exception {

	}

	@Override
	public Receiving findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Receiving)getSession().createCriteria(Receiving.class)
				.setFetchMode("part", FetchMode.JOIN)
				.setFetchMode("employee", FetchMode.JOIN)
				.setFetchMode("order", FetchMode.JOIN)
				.setFetchMode("quantityType", FetchMode.JOIN)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Receiving> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Receiving.class)
				.setFetchMode("part", FetchMode.JOIN)
				.setFetchMode("employee", FetchMode.JOIN)
				.setFetchMode("order", FetchMode.JOIN)
				.setFetchMode("quantityType", FetchMode.JOIN)
				.list();
	}

}
