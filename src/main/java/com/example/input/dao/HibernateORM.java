package com.example.input.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Takurou Nakada
 * Hibernate ORMの抽象クラス
 *
 */
@Transactional
@Repository
public abstract class HibernateORM  {

	/**
	 *  セッションを取得する。
	 *  return: Sessionオブジェクト
	 */
	@Autowired
	protected SessionFactory  sessionFactory;

	protected Session getSession() {

		return  sessionFactory.getCurrentSession();
	}
}
