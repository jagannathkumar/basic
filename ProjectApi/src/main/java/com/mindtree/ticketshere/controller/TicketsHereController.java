package com.mindtree.ticketshere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.service.impl.TicketsHereServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/rest")
public class TicketsHereController {

	@Autowired
	TicketsHereServiceImpl ticketsHereServiceImpl;

	@RequestMapping(value = "/getEvent", method = RequestMethod.POST)
	public List<EventDetails> getEvent(@RequestBody String eventName) {
		return ticketsHereServiceImpl.getEvent(eventName);
	}

	@RequestMapping(value = "/getSpecificEvent", method = RequestMethod.POST)
	public List<Events> getSpecificEvent(@RequestBody String eventName) {
		return ticketsHereServiceImpl.getSpecificEvent(eventName);
	}
	@RequestMapping(value = "/updateVenue", method = RequestMethod.POST)
	public String updateTicket(@RequestBody Ticket ticket) {
		ticketsHereServiceImpl.sentMail(ticket);
		return ticketsHereServiceImpl.updateTicket(ticket);
	}
	@RequestMapping(value = "/checkAvailable", method = RequestMethod.POST)
	public String checkTicketAvailability(@RequestBody Ticket ticket) {
		return ticketsHereServiceImpl.checkTicket(ticket);
	}
     



}
