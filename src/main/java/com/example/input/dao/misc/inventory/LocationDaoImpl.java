package com.example.input.dao.misc.inventory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.inventory.Location;

@Transactional
@Repository
public class LocationDaoImpl extends HibernateORM implements LocationDao {

	@Override
	public void insert(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(location);
	}

	@Override
	public void update(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().update(location);
	}

	@Override
	public void delete(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(location);
	}

	@Override
	public Location findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Location)getSession().createCriteria(Location.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Location.class).list();
	}

}
