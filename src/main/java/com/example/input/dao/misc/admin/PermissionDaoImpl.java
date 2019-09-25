package com.example.input.dao.misc.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.PermissionCheckboxModel;

@Transactional
@Repository
public class PermissionDaoImpl extends HibernateORM implements PermissionDao {

	@Override
	public void insert(PermissionCheckboxModel permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(permission);
	}

	@Override
	public void delete(PermissionCheckboxModel permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(permission);

	}

	@Override
	public void update(PermissionCheckboxModel permission) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(permission);
	}

	@Override
	public PermissionCheckboxModel findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (PermissionCheckboxModel)getSession().createCriteria(PermissionCheckboxModel.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionCheckboxModel> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(PermissionCheckboxModel.class).list();
	}
}
