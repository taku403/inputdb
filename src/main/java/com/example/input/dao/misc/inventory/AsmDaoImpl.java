package com.example.input.dao.misc.inventory;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.example.input.dao.HibernateORM;
import com.example.input.domain.misc.inventory.Asm;

public abstract class AsmDaoImpl extends HibernateORM implements AsmDao {

	@Override
	public void insert(Asm asm) throws Exception {
		getSession().save(asm);

	}

	@Override
	public void update(Asm asm) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().update(asm);
	}

	@Override
	public void delete(Asm asm) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		getSession().delete(asm);
	}

	@Override
	public Asm findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Asm)getSession().createCriteria(Asm.class)
				.setFetchMode("part", FetchMode.JOIN)
				.add(Restrictions.eq("integerid", value))
	}

	@Override
	public List<Asm> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
