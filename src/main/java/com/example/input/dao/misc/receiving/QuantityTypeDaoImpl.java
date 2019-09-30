package com.example.input.dao.misc.receiving;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.receiving.QuantityType;

@Transactional
@Repository
public class QuantityTypeDaoImpl extends HibernateORM implements QuantityTypeDao {

	@Override
	public void insert(QuantityType quantityType) throws Exception {

		getSession().save(quantityType);

	}

	@Override
	public void update(QuantityType quantityType) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().update(quantityType);
	}

	@Override
	public void delete(QuantityType quantityType) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(quantityType);
	}

	@Override
	public QuantityType findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (QuantityType)getSession().createCriteria(QuantityType.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuantityType> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(QuantityType.class).list();
	}

}
