package com.mindtree.ticketshere.service;

import java.util.List;

import com.mindtree.ticketshere.entity.EventDetails;

public interface SearchService {
	public List<EventDetails> getAllEvents();
	public List<EventDetails> getParticularEvent(String eventTitle);
}
