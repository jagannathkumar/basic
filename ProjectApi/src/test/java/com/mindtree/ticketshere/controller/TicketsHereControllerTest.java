package com.mindtree.ticketshere.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
import com.mindtree.ticketshere.controller.TicketsHereController;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.service.impl.TicketsHereServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class , AppConfig.class})
public class TicketsHereControllerTest {
	
	@Mock
	TicketsHereServiceImpl ticketsHereServiceImpl;
	
	@InjectMocks
	TicketsHereController ticketsHereController;
	
	@Spy
	private ArrayList<EventDetails> list = new ArrayList<>();
	private ArrayList<Events> eventList = new ArrayList<>();
	String str;
	Ticket ticket=new Ticket();
	
	@BeforeClass
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		this.list= this.getEvent();
		this.eventList=this.getSpecificEvent();
		this.str = "Raazi";
	}
	
	public ArrayList<EventDetails> getEvent()
	{
		ArrayList<EventDetails> list = new ArrayList<>();
		EventDetails eventDetails = new EventDetails();
		eventDetails.setEventBanner("eventBanner");
		eventDetails.setEventDescription("eventDescription");
		eventDetails.setEventDuration("jdjkkf");
		eventDetails.setEventId(1);
		eventDetails.setEventName("kdjifkh");
		eventDetails.setEventTrailor("djdhufh");
		list.add(eventDetails);
		return list;
	}
	
	@Test
	public void ticketsHereTesting()
	{
		try {
			when(this.ticketsHereServiceImpl.getEvent(this.str)).thenReturn(this.list);
		} catch (Exception e) {
			
		}
		assertEquals(1,this.ticketsHereController.getEvent(this.str).size());
	}
	
	public ArrayList<Events> getSpecificEvent()
	{
		ArrayList<Events> eventList = new ArrayList<>();
		Events event= new Events();
		event.setEventCast("eventCast");
		event.setEventDirector("eventDirector");
		event.setEventGenre("eventGenre");
		event.setEventId(1);
		event.setEventLanguage("eventLanguage");
		event.setEventPoster("eventPoster");
		event.setEventProductionHouse("eventProductionHouse");
		event.setEventTitle("eventTitle");
		eventList.add(event);
		return eventList;
	}
	
	@Test
	public void getSpecificEventTesting() 
	{
		try {
			when(this.ticketsHereServiceImpl.getSpecificEvent(this.str)).thenReturn(this.eventList);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.ticketsHereController.getSpecificEvent(this.str).size());
		
	}
	
	public String updateTicket() {
		return "success";
	}
	
	@Test
	public void updateTicketTesting() {
		try {
			when(this.ticketsHereServiceImpl.updateTicket(this.ticket)).thenReturn("success");
			
		}
		catch (Exception e){
			
		}
		assertEquals("success",this.ticketsHereController.updateTicket(this.ticket));
		
	}

}
