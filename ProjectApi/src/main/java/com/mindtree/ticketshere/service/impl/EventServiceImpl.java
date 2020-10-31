package com.mindtree.ticketshere.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ticketshere.dao.EventDao;

import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.service.EventService;


@Service
@Transactional
public class EventServiceImpl implements EventService
{
	@Autowired
	EventDao eventDaoImpl;
	
	
	public List<Events> display()
	{
		return eventDaoImpl.show();
     }
	
	public List<Events> displayeng()
	{
		return 	eventDaoImpl.showeng();
	 }
	
	public List<Events> displayhin()
	{
		return	eventDaoImpl.showhin();
	}
	public List<Events> displaytel()
	{
		return	eventDaoImpl.showtel();
	}
	
}
