package com.mindtree.ticketshere.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.TimingsSlot;
import com.mindtree.ticketshere.entity.VenueDetails;
import com.mindtree.ticketshere.service.impl.SearchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class,AppConfig.class})
public class SearchControllerTest {
	@Mock
	SearchServiceImpl searchService;
	
	@InjectMocks
	SearchController searchController;
	
	@Spy
	public List<EventDetails> get=new ArrayList<EventDetails>();
	String str;
	
	@BeforeClass
	public void before() {
		MockitoAnnotations.initMocks(this);
		this.get = this.getParticularEvents();
		this.str = "eventname";
	}
	 public List<EventDetails> getParticularEvents()
	 {
		 ArrayList<EventDetails> list = new ArrayList<>();
		 List<TimingsSlot> tslotList = new ArrayList<>();
		 List<VenueDetails> vlist = new ArrayList<>();
		 EventDetails events = new EventDetails();

		 events.setEventBanner("eventBanner");
		 events.setEventDescription("eventDescription");
		 events.setEventDuration("eventDuration");
		 events.setEventId(1);
		 events.setEventName("eventName");
		 events.setEventTrailor("eventTrailor");
		 events.setEventType("eventType");
		 events.setTimingsSlot(tslotList);
		 events.setVenueDetails(vlist);
		 
		 list.add(events);
		 return list;
	 }
	 
	 @Test
	 public void searchTest() {
		 try {
			 when(this.searchService.getParticularEvent(this.str)).thenReturn(this.get);
			 when(this.searchService.getAllEvents()).thenReturn(this.get);
			 when(this.searchService.getParticularEvent(" ")).thenReturn(this.get);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 assertEquals(1,this.searchController.getParticularEvents(this.str).size());
		 assertEquals(1,this.searchController.getAllEvents().size());
		 assertEquals(0,this.searchController.getParticularEvent().size());
	 }
}
