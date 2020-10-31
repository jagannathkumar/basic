package com.myproject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=0;i<10;i++) {
			UserDetails user = new UserDetails();
			user.setName("User"+i);//
			session.save(user);
		}
		UserDetails user= session.get(UserDetails.class, 6);
		System.out.println("user :"+ user);
		session.delete(user);
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

}
