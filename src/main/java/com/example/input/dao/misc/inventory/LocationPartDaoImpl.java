package com.example.input.dao.misc.inventory;

import java.util.List;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.inventory.LocationPart;

public abstract class LocationPartDaoImpl extends HibernateORM implements LocationPartDao {

	@Override
	public void insert(LocationPart locationPart) throws Exception {
		getSession().save(locationPart);

	}

	@Override
	public void update(LocationPart locationPart) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(locationPart);
	}

	@Override
	public void delete(LocationPart locationPart) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(locationPart);
	}

	@Override
	public LocationPart findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<LocationPart> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
