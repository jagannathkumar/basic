package com.mindtree.ticketshere.Dao;

import static org.junit.Assert.assertEquals;



import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.dao.impl.SearchDaoImpl;

public class SearchDaoTest extends EntityDaoImplTest {

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("alleventdata.xml"));
		return dataSet;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SearchDaoImpl searchDao;
	
//	@Spy
//	private List<EventDetails> events=new ArrayList<EventDetails>();
	
	@BeforeClass
	public void testSetUp()
	{
		searchDao.setSessionFactory(sessionFactory);
	}

	@Test
	public void getAllEventTest()
	{
		assertEquals(0,searchDao.getAllEvents().size());
	}
	
	@Test
	public void getAllVenueTest()
	{
		assertEquals(0,searchDao.getAllVenue().size());
	}
	
	@Test
	public void getEventByTypeTest()
	{
		assertEquals(0,searchDao.getEventsByType("music").size());
	}
	
	@Test
	public void getEventByVenueTest()
	{
		assertEquals(0,searchDao.getEventByVenue("inox").size());
	}
}
