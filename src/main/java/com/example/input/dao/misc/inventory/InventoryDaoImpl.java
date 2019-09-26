package com.example.input.dao.misc.inventory;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.inventory.Inventory;

public class InventoryDaoImpl extends HibernateORM implements InventoryDao {

	@Override
	public void insert(Inventory inventory) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().save(inventory);

	}

	@Override
	public void update(Inventory inventory) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(inventory);
	}

	@Override
	public void delete(Inventory inventory) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(inventory);
	}

	@Override
	public Inventory findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Inventory) getSession().createCriteria(Inventory.class)
				.setFetchMode("location", FetchMode.JOIN)
				.setFetchMode("part", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Inventory.class)
				.setFetchMode("location", FetchMode.JOIN)
				.setFetchMode("part", FetchMode.JOIN)
				.list();
	}
}
