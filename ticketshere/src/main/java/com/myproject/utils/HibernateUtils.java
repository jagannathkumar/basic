package com.myproject.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.entity.Location;

public class HibernateUtils {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Object> findByhql(String query){
		Session session = sessionFactory.openSession();
		Query query1 = session.createQuery(query);
		List<Object> list=  query1.getResultList();
		session.close();
		return list;
	}
	
	
}
