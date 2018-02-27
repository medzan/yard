package com.doc.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.doc.spring.listener.SimpleEvent;
import com.doc.spring.model.Simple;

@Repository
@Transactional
public class SimpleDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private ApplicationEventPublisher publisher;

	public void save(Simple simple) {
		// sessionFactory.getCurrentSession().saveOrUpdate(simple);
		System.out.println("executed " + simple);
		publisher.publishEvent(new SimpleEvent(this));
	}

	public void deleteAll(Simple target) {
		// sessionFactory.getCurrentSession().getTransaction().markRollbackOnly();
		throw new NullPointerException();
		// sessionFactory.getCurrentSession().delete(target);
	}

}
