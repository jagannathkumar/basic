package com.myproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * for (int i = 0; i < 10; i++) { UserDetails user1 = new UserDetails();
		 * user1.setName("User" + i); session.save(user1); }
		 */

		UserDetails user = session.get(UserDetails.class, 5);
		//session.getTransaction().commit();
		session.close();
		Session session1 =sessionFactory.openSession();
		UserDetails user1 = session1.get(UserDetails.class, 5);
		System.out.println("user :" + user);
		/*
		 * session.delete(user); session.saveOrUpdate(user);
		 * session.getTransaction().commit();
		 */
		session1.close();		
	}

}
