package com.mindtree.ticketshere.dao;

import java.util.List;

import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.VenueDetails;


public interface SearchDao {
	public List<EventDetails> getAllEvents();
	public List<EventDetails> getEventsByType(String eventType);
	public List<EventDetails> getEventByVenue(String venueName);
	public List<VenueDetails> getAllVenue();
}
