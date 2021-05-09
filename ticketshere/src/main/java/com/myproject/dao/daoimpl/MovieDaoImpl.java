package com.myproject.dao.daoimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.dao.MovieDao;
import com.myproject.dto.UserDetails;
import com.myproject.entity.Address;
import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;
import com.myproject.entity.Theatre;
import com.myproject.entity.User;
import com.myproject.utils.HibernateUtils;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class MovieDaoImpl extends HibernateUtils implements MovieDao {

	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction;

	@Override
	public List<Movies> getMovies() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Movies");
		// Query query = HibernateUtils.getSession().createQuery("from Movies");
		// session.beginTransaction();
		List<Movies> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public List<Language> getLanguage() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Language");
		// session.beginTransaction();
		List<Language> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public List<RunningShows> getRunningShows() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from RunningShows");
		// session.beginTransaction();
		List<RunningShows> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public Booking bookTicket(RunningShows runningShows) {
		Booking bk = new Booking();
		bk.setRunningShows(runningShows);
		Session session = sessionFactory.openSession();
		// transaction = session.beginTransaction();
		// transaction.begin();
		session.save(bk);
		// transaction.commit();
		session.close();
		return bk;
	}

	@Override
	public List<Location> getLocation() {
		// Session session = sessionFactory.openSession();
		// Query query = session.createQuery("from Location");
		// List<Location> list= query.getResultList();
		// session.close();
		// return list;
		List<Location> location = new ArrayList<Location>();
		String query = "from Location";
		super.findByhql(query).stream().forEach(x -> location.add((Location) x));
		return location;
	}

	@Override
	public Language getLanguage(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Language where id=?");
		query.setParameter(0, id);
		return (Language) query.getResultList().get(0);
	}

	@Override
	public UserDetails getUserDetails(int userId) {
		UserDetails userDetails = new UserDetails();
		Session session = sessionFactory.getCurrentSession();
		//Query query = session.createQuery("from Address a INNER JOIN a.user u where u.userId=?");
		Query query = session.createQuery("select u.name,a.addressLine from Address a INNER JOIN a.user u where u.userId=?");
		query.setParameter(0, userId);
		/*
		 * List<Object[]> address = (List<Object[]>)query.getResultList(); List<Address>
		 * addr = new ArrayList<Address>(); for(Object[] add: address)
		 * addr.add((Address)add[0]);
		 * userDetails.setUserName(addr.get(0).getUser().getName());
		 * userDetails.setAddress(addr); return userDetails;
		 */
		List<String> addr=Collections.emptyList();
		String user="";
		List<Object[]> list =query.getResultList();
		for(Object[] obj:list) {
			user=(String)obj[0];
			addr.add((String)obj[1]);
		}
		userDetails.setUserName(user);
		userDetails.setAddress(addr);
		return userDetails;
	}

}
