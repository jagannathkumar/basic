package com.mindtree.ticketshere.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.SearchDao;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.VenueDetails;
import com.mindtree.ticketshere.service.SearchService;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	SearchDao searchDao;
	
	public List<EventDetails> getAllEvents()
	{
		return searchDao.getAllEvents();
	}
	
	public List<EventDetails> getParticularEvent(String eventTitle)
	{
		List<EventDetails> finalEventList = new ArrayList<>();
		
		List<EventDetails> allEvents = searchDao.getAllEvents();
		
		List<VenueDetails> allVenues = searchDao.getAllVenue();
		
		int flag=0;
		Set<String> allEventSet=new HashSet<String>();
		Set<String> allVenueSet=new HashSet<String>();
		Iterator itr=allEvents.iterator();
		
		//adding all event in set
		while(itr.hasNext())
		{
			EventDetails ev=(EventDetails) itr.next();
			allEventSet.add(ev.getEventType());
		}
	
		itr=allVenues.iterator();
		
		//adding all venue in set
		while(itr.hasNext())
		{
			VenueDetails venue=(VenueDetails) itr.next();
			allVenueSet.add(venue.getVenueName());
		}
		
		
		itr=allEventSet.iterator();
		
		while(itr.hasNext())
		{
			if(eventTitle.equalsIgnoreCase((String) itr.next()))
			{
				flag=1;
				break;
			}
		}
		
		if(flag!=1)
		{
			itr=allVenueSet.iterator();
			while(itr.hasNext())
			{
				if(eventTitle.equalsIgnoreCase((String) itr.next()))
				{
					flag=2;
					break;
				}
			}
		}
			
		System.out.println("flag"+ flag);
		if(flag==1)
		{
			finalEventList=searchDao.getEventsByType(eventTitle);
		}
		else if(flag==2)
		{
			finalEventList=searchDao.getEventByVenue(eventTitle);
		}
		else {
			
			Iterator it = allEvents.iterator();
			String check;
			while (it.hasNext()) {
				EventDetails event = (EventDetails) it.next();
				check = event.getEventName();
				if (check.toLowerCase().contains(eventTitle.toLowerCase()))
					finalEventList.add(event);
			}
		}
		return finalEventList;
	}
}
