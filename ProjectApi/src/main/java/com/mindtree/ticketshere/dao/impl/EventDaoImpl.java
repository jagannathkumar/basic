package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.dao.EventDao;
import com.mindtree.ticketshere.entity.Events;




@Repository
public class EventDaoImpl implements EventDao
{
	@Autowired
    SessionFactory sessionFactory;

	 public void setSessionfactory(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
	
	 @SuppressWarnings("unchecked")
	public List<Events> show() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Events");
		return query.getResultList();
	}
     
	 @SuppressWarnings("unchecked")
	 public List<Events> showeng()
	{
		Session session=sessionFactory.getCurrentSession();
	    String hql2=" From Events where eventLanguage=:lan or eventLanguage1=:lan or eventLanguage2=:lan ";

		Query query2=session.createQuery(hql2);
		 query2.setParameter("lan","English");
		 return query2.getResultList();
	 } 
	 @SuppressWarnings("unchecked")
	public List<Events> showhin()
	{
		Session session=sessionFactory.getCurrentSession();
	    String hql3=" From Events where eventLanguage=:lan or eventLanguage1=:lan or eventLanguage2=:lan ";
        Query query3=session.createQuery(hql3);
		 query3.setParameter("lan","Hindi");

		  return query3.getResultList();

	 }
	  
	 @SuppressWarnings("unchecked")
	  public List<Events> showtel()
	{
		Session session=sessionFactory.getCurrentSession();
	    String hql4=" From Events where eventLanguage=:lan or eventLanguage1=:lan or eventLanguage2=:lan  ";
		Query query4=session.createQuery(hql4);
		 query4.setParameter("lan","Telugu");
		  return query4.getResultList();
	}

		     
		
	}



