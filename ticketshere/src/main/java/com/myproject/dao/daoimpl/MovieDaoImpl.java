package com.myproject.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.dao.MovieDao;
import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;
import com.myproject.entity.Theatre;
import com.myproject.utils.HibernateUtils;

public class MovieDaoImpl extends HibernateUtils implements MovieDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction;
	@Override
	public List<Movies> getMovies() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Movies");
		//Query query = HibernateUtils.getSession().createQuery("from Movies");
		//session.beginTransaction();
		List<Movies> list = query.getResultList();
		session.close();
		return list;
	}
	@Override
	public List<Language> getLanguage() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Language");
		//session.beginTransaction();
		List<Language> list = query.getResultList();
		session.close();
		return list;
	}
	@Override
	public List<RunningShows> getRunningShows() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from RunningShows");
		//session.beginTransaction();
		List<RunningShows> list = query.getResultList();
		session.close();
		return list;
	}
	@Override
	public Booking bookTicket(RunningShows runningShows) {
		Booking bk = new Booking();
		bk.setRunningShows(runningShows);
		Session session = sessionFactory.openSession();
		//transaction = session.beginTransaction();
		//transaction.begin();
		session.save(bk);
		//transaction.commit();
		session.close();
		return bk;
	}
	@Override
	public List<Location> getLocation() {
		//Session session = sessionFactory.openSession();
		//Query query = session.createQuery("from Location");
		//List<Location> list= query.getResultList();
		//session.close();
		//return list;
		List<Location> location = new ArrayList();
		String query="from Location";
		super.findByhql(query).stream().forEach(x->location.add((Location)x));
		return location;
	}

}
