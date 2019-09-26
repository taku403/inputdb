package com.example.input.dao.misc.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Permission;

@Transactional
@Repository
public class PermissionDaoImpl extends HibernateORM implements PermissionDao {

	@Override
	public void insert(Permission permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(permission);
	}

	@Override
	public void delete(Permission permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(permission);

	}

	@Override
	public void update(Permission permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(permission);
	}

	@Override
	public Permission findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Permission)getSession().createCriteria(Permission.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Permission.class).list();
	}
}
