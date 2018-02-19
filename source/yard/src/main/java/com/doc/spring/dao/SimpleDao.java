package com.doc.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doc.spring.model.Simple;

@Repository
@Transactional
public class SimpleDao {

	@Autowired
	SessionFactory sessionFactory;

	public void save(Simple simple) {
		sessionFactory.getCurrentSession().saveOrUpdate(simple);
	}
	
	
}
