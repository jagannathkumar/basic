package com.mindtree.ticketshere.dao;

import java.util.List;

import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;

public interface TicketsHereDao {
	
	public List<EventDetails> getEvent(String eventName);
	public List<Events> getSpecificEvent(String eventName);
	public void insertintoEvent(EventDetails eventDetails);
	public String updateTicket(Ticket ticket);

}
