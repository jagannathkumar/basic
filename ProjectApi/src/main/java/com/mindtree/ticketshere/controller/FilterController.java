package com.mindtree.ticketshere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.service.EventService;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class FilterController
{
	@Autowired
	EventService eventserviceImpl;
	
	 @RequestMapping(value="/getlanguage", method=RequestMethod.GET)
    public List<Events> getlanguage()
      {
	    return eventserviceImpl.display();
	  }
	 @RequestMapping(value="/getenglish", method=RequestMethod.GET)
	 public List<Events> getenglish()
	  {
	   return  eventserviceImpl.displayeng();
      }

	 @RequestMapping(value="/gethindi", method=RequestMethod.GET)
	 public List<Events> gethindi()
	 {		
		 return eventserviceImpl.displayhin();
	 }
	 
	 @RequestMapping(value="/gettelugu", method=RequestMethod.GET)
	 public List<Events> gettelugu()
	 {	
		return eventserviceImpl.displaytel();
		 
	 }
	
	
 


}
