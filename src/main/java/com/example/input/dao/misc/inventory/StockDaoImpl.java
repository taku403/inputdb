package com.example.input.dao.misc.inventory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.inventory.Stock;

@Transactional
@Repository
public class StockDaoImpl extends HibernateORM implements StockDao {

	@Override
	public void insert(Stock stock) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().save(stock);

	}

	@Override
	public void update(Stock stock) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(stock);
	}

	@Override
	public void delete(Stock stock) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(stock);
	}

	@Override
	public Stock findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Stock)getSession().createCriteria(Stock.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Stock.class)
				.list();
	}

}
