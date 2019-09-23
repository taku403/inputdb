package com.example.input.dao.misc.department;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Department;

@Transactional
@Repository
public class DepartmentDaoImpl extends HibernateORM implements DepartmentDao {

	@Override
	public void insert(Department department) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().save(department);
	}

	@Override
	public void delete(Department department) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(department);
	}

	@Override
	public void update(Department department) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(department);
	}

	@Override
	public Department findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Department)getSession().createCriteria(Department.class).add(Restrictions.eq("id", id)).uniqueResult();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Department.class).list();
	}

}
