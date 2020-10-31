package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.dao.DaoLoginSignup;
import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;

@Repository
public class DaoLoginSignUp implements DaoLoginSignup {
	@Autowired
	SessionFactory sessionFactory;
	
	String failureflag="failure";
	String sucessflag="sucess";

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public void insert(User user) { // inserting into db details of user.
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public boolean isPresent(User user) { // checking if a user is already present
		boolean isValid = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> userlist = query.getResultList();
		for (User use : userlist) {
			if (use.getEmail().equalsIgnoreCase(user.getEmail())) {
				isValid = true;
				break;
			}

		}
		return isValid;

	}

	public User isValid(User user) { // checking if a user's credentials are valid
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> userlist = query.getResultList();
		for (User use : userlist) {
			if (use.getEmail().equalsIgnoreCase(user.getEmail()) && use.getPassword().equals(user.getPassword())) {
				use.setFlag(sucessflag);
				return use;
			}

		}
		user.setFlag(failureflag);
		return user;
	}

	public void insertOrganizer(Organizer organizer) { // inserting into db details of Organizer.
		Session session = sessionFactory.getCurrentSession();
		session.save(organizer);
	}

	public boolean isPresentOrganizer(Organizer organizer) { // checking if a organizer is already present in the db
		boolean isValid = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Organizer");
		@SuppressWarnings("unchecked")
		List<Organizer> organizerList = query.getResultList();
		for (Organizer organizerVariable : organizerList) {
			if (organizerVariable.getEmail().equalsIgnoreCase(organizer.getEmail())) {
				isValid = true;
				break;
			}

		}
		return isValid;

	}

	public Organizer isValidOrgainizer(Organizer organizer) { // checking if a organizer's credentials are valid
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Organizer");
		@SuppressWarnings("unchecked")
		List<Organizer> organizerList = query.getResultList();
		for (Organizer organizerVariable : organizerList) {
			if (organizerVariable.getEmail().equalsIgnoreCase(organizer.getEmail())
					&& organizerVariable.getPassword().equals(organizer.getPassword())) {
				organizerVariable.setFlag(sucessflag);
				return organizerVariable;
			}

		}
		organizer.setFlag(failureflag);
		return organizer;
	}
}