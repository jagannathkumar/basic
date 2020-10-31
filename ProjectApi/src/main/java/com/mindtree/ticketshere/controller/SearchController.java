package com.mindtree.ticketshere.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.EventDetails;

import com.mindtree.ticketshere.service.SearchService;


@RestController
@CrossOrigin
@RequestMapping("/rest")
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@RequestMapping(value="/getAllEvents",method=RequestMethod.GET)
	public List<EventDetails> getAllEvents()
	{
		return searchService.getAllEvents();
	}
	
	@RequestMapping(value="/getEventsByName/{title}",method=RequestMethod.GET)
	public List<EventDetails> getParticularEvents(@PathVariable("title") String eventTitle)
	{
		return searchService.getParticularEvent(eventTitle);
	}
	
	@RequestMapping(value="/getEventsByName/",method=RequestMethod.GET)
	public List<EventDetails> getParticularEvent()
	{
		return new ArrayList<>();
	}
}
