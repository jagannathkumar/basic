package com.mindtree.ticketshere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.service.impl.CancelBookingServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class CancelBookingController {
	@Autowired
	CancelBookingServiceImpl cancelBookingsevice;

	@RequestMapping(value = "/getBooking", method = RequestMethod.POST)
	public ResponseEntity<Ticket> getBookings(@RequestBody String bookingId) {
		if(cancelBookingsevice.isPresent(bookingId))
		{
		return new ResponseEntity<>(cancelBookingsevice.cancelBooking(bookingId), HttpStatus.OK);
	}
		else {
			Ticket ticket=null;
			return new ResponseEntity<>(ticket, HttpStatus.OK);
		}	
	}
	@RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
	public ResponseEntity<String> cancelBooking(@RequestBody String bookingId) {
			return new ResponseEntity<>(cancelBookingsevice.deleteBooking(bookingId), HttpStatus.OK);
		}	
	}
		


