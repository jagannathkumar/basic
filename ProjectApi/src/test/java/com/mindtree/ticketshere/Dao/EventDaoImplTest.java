package com.mindtree.ticketshere.Dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.SessionFactory;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.dao.impl.EventDaoImpl;
import com.mindtree.ticketshere.entity.Events;

public class EventDaoImplTest extends EntityDaoImplTest{

	@Override
	protected  IDataSet getDataSet() throws Exception
	{
		IDataSet dataSet=new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("EventsDataSet.xml"));
		return dataSet;
	}
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired
	private EventDaoImpl eventDao;
	
	@Spy
	private  List<Events> events=new ArrayList<>();
	
	@BeforeClass
	public void testSetUp() throws Exception
	{
		
		eventDao.setSessionfactory(sessionFactory);
		
	}
	@Test
	public void showTest()
	{
		assertEquals(eventDao.show().size(),6);
	}
	@Test
	public void showengTest()
	{
		assertEquals(4,eventDao.showeng().size());
	}
	@Test
	public void showhinTest()
	{
		assertEquals(6,eventDao.showhin().size());
	}
	@Test
	public void showtelTest()
	{
		assertEquals(4,eventDao.showtel().size());
	}
}









	
	
	
	

	
	


	


