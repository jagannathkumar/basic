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
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.service.impl.EventServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class , AppConfig.class})
public class FilterControllerTest 
{
	 @Mock
     EventServiceImpl eventServiceImpl;
	
	@InjectMocks
	FilterController filterController;
	
	@Spy
	private ArrayList<Events> eventList = new ArrayList<>();
	private ArrayList<Events> englishevent=new ArrayList<>();
	private ArrayList<Events> hindievent=new ArrayList<>();
	private ArrayList<Events> teluguevent=new ArrayList<>();
	
	@BeforeClass
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		this.eventList=this.getlanguage();
		this.englishevent=this.getenglish();
		this.hindievent=this.gethindi();
		this.teluguevent=this.gettelugu();
	}

    private ArrayList<Events> getlanguage()
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
	public void getlanguageTesting() 
	{
		try {
			when(this.eventServiceImpl.display()).thenReturn(this.eventList);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.filterController.getlanguage().size());
		
	}
	
	private ArrayList<Events> getenglish()
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
	public void getenglishTesting() 
	{
		try {
			when(this.eventServiceImpl.displayeng()).thenReturn(this.englishevent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.filterController.getenglish().size());
		
	}
	private ArrayList<Events> gethindi()
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
	public void gethindiTesting() 
	{
		try {
			when(this.eventServiceImpl.displayhin()).thenReturn(this.hindievent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.filterController.gethindi().size());
		
	}
	private ArrayList<Events> gettelugu()
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
	public void getteluguTesting() 
	{
		try {
			when(this.eventServiceImpl.displaytel()).thenReturn(this.teluguevent);
			
		}
		catch (Exception e){
			
		}
		assertEquals(1,this.filterController.gettelugu().size());
		
	}
	

}
