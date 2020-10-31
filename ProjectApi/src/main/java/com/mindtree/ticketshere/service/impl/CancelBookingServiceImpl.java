package com.mindtree.ticketshere.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.impl.CancelBookingDaoImpl;
import com.mindtree.ticketshere.entity.Ticket;

@Service
@Transactional
public class CancelBookingServiceImpl {
	@Autowired
	CancelBookingDaoImpl cancelBookingDao;

	public Ticket cancelBooking(String bookingId) {
		return cancelBookingDao.cancelTicket(bookingId);
	}

	public boolean isPresent(String bookingId) {
		return cancelBookingDao.isPresent(bookingId);
	}

	public String deleteBooking(String bookingId) {
		return cancelBookingDao.deleteTicket(bookingId);
	}

}
