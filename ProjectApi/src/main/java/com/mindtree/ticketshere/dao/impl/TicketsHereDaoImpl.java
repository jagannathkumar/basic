package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.ticketshere.dao.TicketsHereDao;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.entity.TimingsSlot;

@Repository
public class TicketsHereDaoImpl implements TicketsHereDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<EventDetails> getEvent(String eventName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EventDetails e where e.eventName=:eventName");
		query.setParameter("eventName", eventName);
		return query.getResultList();
	}

	public void insertintoEvent(EventDetails eventDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.save(eventDetails);
	}
	
	public String updateTicket(Ticket ticket) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from TimingsSlot where timingsSlot_eventId=:eventId and language=:eventlanguage and startTime=:timing");
		query.setParameter("eventId", ticket.getEventId());
		query.setParameter("eventlanguage", ticket.getEventLanguage());
		query.setParameter("timing", ticket.getTiming());
		TimingsSlot timing= new TimingsSlot();
		timing = (TimingsSlot) query.getSingleResult();
		timing.setNumberOfSeats(timing.getNumberOfSeats()-ticket.getNumberOfSeats());
		session.update(timing);
		session.save(ticket);
		return "success";
	}
	
	public String checkTicket(Ticket ticket) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from TimingsSlot where timingsSlot_eventId=:eventId and language=:eventlanguage and startTime=:timing");
		query.setParameter("eventId", ticket.getEventId());
		query.setParameter("eventlanguage", ticket.getEventLanguage());
		query.setParameter("timing", ticket.getTiming());
		TimingsSlot timing= new TimingsSlot();
		timing = (TimingsSlot) query.getSingleResult();
		if((timing.getNumberOfSeats()-ticket.getNumberOfSeats()>=0)) {
		return "success";
	}
		else return "failure";	
	}


	@SuppressWarnings("unchecked")
	public List<Events> getSpecificEvent(String eventName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Events e where e.eventTitle=:eventName");
		query.setParameter("eventName", eventName);
		return query.getResultList();
	}
}
