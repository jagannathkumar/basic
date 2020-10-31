package com.mindtree.ticketshere.Dao;

import static org.junit.Assert.assertEquals;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.dao.impl.DaoLoginSignUp;
import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;

public class LoginSignUpDaoTest extends EntityDaoImplTest {

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("alleventdata.xml"));
		return dataSet;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DaoLoginSignUp daoLoginSignUp;
	
	@BeforeClass
	public void testSetUp()
	{
		daoLoginSignUp.setSessionFactory(sessionFactory);
	}
	
	@Test
	public void isPresentTest()
	{
		User user = new User();
		assertEquals(false,daoLoginSignUp.isPresent(user));
	}
	
	@Test
	public void isValidTest()
	{
		User user = new User();
		assertEquals(daoLoginSignUp.isValid(user),user);
	}
	
	@Test
	public void isPresentOrganizerTest()
	{
		Organizer organizer=new Organizer();
		assertEquals(false,daoLoginSignUp.isPresentOrganizer(organizer));
	}
	
	@Test
	public void isValidOrgainizerTest()
	{
		Organizer organizer=new Organizer();
		assertEquals(daoLoginSignUp.isValidOrgainizer(organizer),organizer);
	}
}
