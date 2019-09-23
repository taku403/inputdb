package com.example.input.dao.misc.employee;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl extends HibernateORM implements EmployeeDao {

	@Override
	public void insert(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		employee.setRegisterd(new Date());
		employee.setUpdate(new Date());
		getSession().save(employee);
	}

	@Override
	public void delete(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(employee);
	}

	@Override
	public void update(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		employee.setUpdate(new Date());
		getSession().update(employee);
	}

	@Override
	public Employee findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Employee) getSession().createCriteria(Employee.class).setFetchMode("department", FetchMode.JOIN)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return getSession().createCriteria(Employee.class).setFetchMode("department", FetchMode.JOIN)
				.list();
	}

	@Override
	public Employee findByLoginIdandLoginPass(String loginId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Employee)getSession().createCriteria(Employee.class).add(Restrictions.eq("loginId", loginId)).uniqueResult();
	}
}
