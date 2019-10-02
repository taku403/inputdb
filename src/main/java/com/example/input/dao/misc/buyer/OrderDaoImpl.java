package com.example.input.dao.misc.buyer;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.buyer.Order;

@Transactional
@Repository
public class OrderDaoImpl extends HibernateORM implements OrderDao {

	@Override
	public void insert(Order order) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		order.setOrderDate(new Date());
		order.setReceivingQuantity(new Integer(0));
		order.setRemainQuantity(new Integer(order.getQuantity()));
		getSession().save(order);
	}

	@Override
	public void delete(Order order) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(order);

	}

	@Override
	public void update(Order order) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		order.setOrderDate(new Date());
		getSession().update(order);
	}

	@Override
	public Order findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Order) getSession().createCriteria(Order.class)
				.setFetchMode("part", FetchMode.JOIN)
				.setFetchMode("employee", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Order.class)
				.setFetchMode("part", FetchMode.JOIN)
				.setFetchMode("employee", FetchMode.JOIN)
				.setFetchMode("part.supplier", FetchMode.JOIN)
				.list();
	}
}

