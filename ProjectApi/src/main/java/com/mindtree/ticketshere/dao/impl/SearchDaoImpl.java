package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.dao.SearchDao;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.VenueDetails;

@SuppressWarnings("deprecation")
@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EventDetails> getAllEvents() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EventDetails");
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EventDetails> getEventsByType(String eventType) {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EventDetails where eventType= ?");
		query.setParameter(0, eventType);
		//session.close();
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EventDetails> getEventByVenue(String venueName) {

		System.out.println("eventbyvenue" + venueName);
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from eventdetails where eventId in (select EventDetails_eventId from eventdetails_venuedetails where venueDetails_venueId in(select venueId from venuedetails where venueName = :venue ))");
		query.addEntity(EventDetails.class);
		query.setParameter("venue", venueName);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VenueDetails> getAllVenue() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from VenueDetails");
		return query.getResultList();
	}
}
