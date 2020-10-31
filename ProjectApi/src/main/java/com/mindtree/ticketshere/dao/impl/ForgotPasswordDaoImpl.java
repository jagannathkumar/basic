package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.entity.User;

@Repository
public class ForgotPasswordDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public void updateOtpStartTime(User user, String otp, String startTime) {
		 Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from User u where u.email=:email");
		query.setParameter("email", user.getEmail());
		User userDetails = (User) query.getSingleResult();
		System.out.println(userDetails);
		userDetails.setOtp(otp);
		userDetails.setOtpStartTime(startTime);
		session.update(userDetails);

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

	public User getUserWithOtp(String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.email=:email");
		query.setParameter("email", userEmail);
		return ((User) query.getSingleResult());

	}
	public String updatePsword(User user)
	{
		User userDetails = new User();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.email=:email");
		query.setParameter("email", user.getEmail());
		userDetails = (User) query.getSingleResult();
		System.out.println(userDetails);
		userDetails.setPassword(user.getPassword());
		session.update(userDetails);
		return "Password changed";
		
	}
}