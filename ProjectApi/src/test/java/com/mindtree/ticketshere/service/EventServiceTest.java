package com.mindtree.ticketshere.service;

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
import com.mindtree.ticketshere.dao.impl.EventDaoImpl;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.service.impl.EventServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes= {HibernateConfiguration.class,AppConfig.class})
public class EventServiceTest
{
	@Mock
	 private EventDaoImpl eventDaoImpl;
	
	@InjectMocks
	private EventServiceImpl eventServiceImpl;
	
	
	@Spy
	private ArrayList<Events> eventList = new ArrayList<>();
	private ArrayList<Events> englishevent=new ArrayList<>();
	private ArrayList<Events> hindievent=new ArrayList<>();
	private ArrayList<Events> teluguevent=new ArrayList<>();
	
	@BeforeClass
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		this.eventList=this.display();
		this.englishevent=this.displayeng();
		this.hindievent=this.displayhin();
		this.teluguevent=this.displaytel();
	}


	private ArrayList<Events> display()
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
	public void displayTesting() 
	{
		try {
			when(this.eventDaoImpl.show()).thenReturn(this.eventList);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.eventServiceImpl.display().size());
		
	}
	
	private ArrayList<Events> displayeng()
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
	public void displayengTesting() 
	{
		try {
			when(this.eventDaoImpl.showeng()).thenReturn(this.englishevent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.eventServiceImpl.displayeng().size());
		
	}
	private ArrayList<Events> displayhin()
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
	public void displayhinTesting() 
	{
		try {
			when(this.eventDaoImpl.showhin()).thenReturn(this.hindievent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.eventServiceImpl.displayhin().size());
		
	}
	private ArrayList<Events> displaytel()
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
	public void displaytelTesting() 
	{
		try {
			when(this.eventDaoImpl.showtel()).thenReturn(this.teluguevent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.eventServiceImpl.displaytel().size());
		
	}

}
