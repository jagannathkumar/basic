package com.mindtree.ticketshere.Dao;

import static org.junit.Assert.assertEquals;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.dao.impl.TicketsHereDaoImpl;

public class TicketsHereDaoImplTest extends EntityDaoImplTest{

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("alleventdata.xml"));
		return dataSet;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private TicketsHereDaoImpl ticketsHereDao;
	
	@BeforeClass
	public void testSetUp()
	{
		ticketsHereDao.setSessionFactory(sessionFactory);
	}
	
	@Test
	public void getEventTest()
	{
		assertEquals(ticketsHereDao.getEvent("raazi").size(),0);
	}
	
	@Test
	public void getSpecificEventTest()
	{
		assertEquals(ticketsHereDao.getSpecificEvent("raazi").size(),0);
	}
	
}
