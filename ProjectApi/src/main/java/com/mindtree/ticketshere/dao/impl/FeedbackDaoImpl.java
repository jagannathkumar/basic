package com.mindtree.ticketshere.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.entity.Feedback;

@Repository
public class FeedbackDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
 public String submitFeedback(Feedback feedback)
 {
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
		return "success";
 }

}
