package com.mindtree.ticketshere.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.entity.TimingsSlot;

@Repository
public class CancelBookingDaoImpl {
	@Autowired
	SessionFactory sessionFactory;

	public Ticket cancelTicket(String bookingId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Ticket t where t.bookingId=:bookingID");
		query.setParameter("bookingID", bookingId);
		return (Ticket) query.getSingleResult();

	}

	public boolean isPresent(String bookingId) { // checking if a booking is there or not
		boolean isValid = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Ticket");
		@SuppressWarnings("unchecked")
		List<Ticket> ticketlist = query.getResultList();
		for (Ticket tickets : ticketlist) {
			if (tickets.getBookingId().equalsIgnoreCase(bookingId)) {
				isValid = true;
				break;
			}

		}
		return isValid;
	}

	public String deleteTicket(String bookingId) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Ticket t where t.bookingId=:bookingID");
		query.setParameter("bookingID", bookingId);
		Ticket ticket = (Ticket) query.getSingleResult();
		Query updatequery = session.createQuery(
				"from TimingsSlot where timingsSlot_eventId=:eventId and language=:eventlanguage and startTime=:timing");
		updatequery.setParameter("eventId", ticket.getEventId());
		updatequery.setParameter("eventlanguage", ticket.getEventLanguage());
		updatequery.setParameter("timing", ticket.getTiming());
		TimingsSlot timing = (TimingsSlot) updatequery.getSingleResult();
		timing.setNumberOfSeats(timing.getNumberOfSeats() + ticket.getNumberOfSeats());
		session.update(timing);
		session.delete(ticket);
		return "success";
	}

}
