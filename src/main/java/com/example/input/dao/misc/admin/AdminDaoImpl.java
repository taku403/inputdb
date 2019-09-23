package com.example.input.dao.misc.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Admin;
import com.example.input.domain.misc.admin.Employee;

@Transactional
@Repository
public class AdminDaoImpl extends HibernateORM implements AdminDao {

	public AdminDaoImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void insert(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(admin);
	}

	@Override
	public void update(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(admin);
	}

	@Override
	public void delete(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(admin);
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Admin) getSession().createCriteria(Admin.class).setFetchMode("employee", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Admin.class).setFetchMode("employee", FetchMode.JOIN).list();
	}

	@Override
	public Admin findByEmployee(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Admin)getSession().createCriteria(Admin.class).setFetchMode("employee", FetchMode.JOIN).add(Restrictions.eq("employee.id", employee.getId())).uniqueResult();
	}

}
