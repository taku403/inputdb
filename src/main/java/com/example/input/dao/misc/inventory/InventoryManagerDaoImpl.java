package com.example.input.dao.misc.inventory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.inventory.InventoryManager;

@Transactional
@Repository
public class InventoryManagerDaoImpl extends HibernateORM implements InventoryManagerDao {

	public InventoryManagerDaoImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void insert(InventoryManager manager) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().save(manager);
	}

	@Override
	public void delete(InventoryManager manager) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		getSession().delete(manager);
	}

	@Override
	public void update(InventoryManager manager) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(manager);
	}

	@Override
	public InventoryManager findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (InventoryManager)getSession().createCriteria(InventoryManager.class).add(Restrictions.eq("id",id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryManager> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		return getSession().createCriteria(InventoryManager.class).list();
	}

	@Override
	public InventoryManager findByEmployee(Employee employee) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (InventoryManager)getSession().createCriteria(InventoryManager.class)
				.setFetchMode("employee", FetchMode.JOIN).add(Restrictions.eq("employee.id", employee.getId()))
				.uniqueResult();
	}

}
