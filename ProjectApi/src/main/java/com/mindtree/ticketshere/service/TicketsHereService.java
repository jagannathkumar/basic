package com.mindtree.ticketshere.service;

import java.util.List;

import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;

public interface TicketsHereService {
	
	public List<EventDetails> getEvent(String eventName);
	public List<Events> getSpecificEvent(String eventName);
	public String updateTicket(Ticket ticket);

}
