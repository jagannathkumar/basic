package com.mindtree.ticketshere.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
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
import com.mindtree.ticketshere.configuration.WebInitializer;
import com.mindtree.ticketshere.dao.impl.DaoLoginSignUp;
import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;
import com.mindtree.ticketshere.service.impl.LoginSignupService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class, WebInitializer.class })
public class LoginSignupServiceTest {
	@Mock
	private DaoLoginSignUp loginSignupDao;
	@InjectMocks
	private LoginSignupService loginSignupService;
	@Spy
	private User user;
	private Organizer organizer;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = getUser();
		organizer = getOrganizer();
	}

	@Test
	public void isPresentUserTestTrue() {
		User userInput = new User();
		userInput.setEmail("demo@mail.com");
		userInput.setPassword("Qwertyuiop1@");
		userInput.setMobileNo("9779798809");
		userInput.setCity("BBSR");
		userInput.setName("Demo");
		when(loginSignupDao.isPresent(userInput)).thenReturn(true);
		assertEquals(true, loginSignupService.isPresent(userInput));
	}
	@Test
	public void isPresentUserTestFalse() {
		User userInput = new User();
		userInput.setEmail("demoeede@mail.com");
		userInput.setPassword("Qwewrtyuiop1@");
		userInput.setMobileNo("9779798809");
		userInput.setCity("BBSR");
		userInput.setName("Demo");
		when(loginSignupDao.isPresent(userInput)).thenReturn(false);
		assertEquals(false, loginSignupService.isPresent(userInput));
	}

	@Test
	public void isPresentOrganizerTestTrue() {
		Organizer organizerInput= new Organizer();
		organizerInput.setEmail("demo@mail.com");
		organizerInput.setPassword("Qwertyuiop1@");
		organizerInput.setName("Demo");
		organizerInput.setMobileNo("9008978809");
		when(loginSignupDao.isPresentOrganizer(organizerInput)).thenReturn(true);
		assertEquals(true, loginSignupService.isPresentOrganizer(organizerInput));
	}
	@Test
	public void isPresentOrganizerTestFalse() {
		Organizer organizerInput= new Organizer();
		organizerInput.setEmail("demoaa@mail.com");
		organizerInput.setPassword("Qwertyeuiop1@");
		organizerInput.setName("Demo");
		organizerInput.setMobileNo("9008978809");
		when(loginSignupDao.isPresentOrganizer(organizerInput)).thenReturn(false);
		assertEquals(false, loginSignupService.isPresentOrganizer(organizerInput));
	}
	
	@Test
	public void isValidUserTestTrue()
	{
		User userInput = new User();
		userInput.setEmail("demo@mail.com");
		userInput.setPassword("Qwertyuiop1@");
		when(loginSignupDao.isValid(userInput)).thenReturn(user);
		assertEquals(user.getEmail(), loginSignupService.isValid(userInput).getEmail());
		}
	@Test
	public void isValidUserTestFalse()
	{
		User userInput = new User();
		userInput.setEmail("demosa@mail.com");
		userInput.setPassword("Qweasrtyuiop1@");
		when(loginSignupDao.isValid(userInput)).thenReturn(null);
		assertEquals(null, loginSignupService.isValid(userInput));
		}
	@Test
	public void isValidOrganizerTestTrue()
	{Organizer organizerInput= new Organizer();
	organizerInput.setEmail("demo@mail.com");
	organizerInput.setPassword("Qwertyuiop1@");
		when(loginSignupDao.isValidOrgainizer(organizerInput)).thenReturn(organizer);
		assertEquals(organizer.getEmail(), loginSignupService.isValidOrganizer(organizerInput).getEmail());
		}
	@Test
	public void isValidOrganizerTestFalse()
	{Organizer organizerInput= new Organizer();
	organizerInput.setEmail("demo12@mail.com");
	organizerInput.setPassword("Qw2wertyuiop1@");
		when(loginSignupDao.isValidOrgainizer(organizerInput)).thenReturn(null);
		assertEquals(null, loginSignupService.isValidOrganizer(organizerInput));
		}

	private Organizer getOrganizer() {
		Organizer organizer = new Organizer();
		organizer.setName("Demo");
		organizer.setEmail("demo@mail.com");
		organizer.setMobileNo("9008978809");
		organizer.setPassword("Qwertyuiop1@");
		organizer.setOrganizerId(10);
		return organizer;
	}

	private User getUser() {
		User user = new User();
		user.setName("Demo");
		user.setEmail("demo@mail.com");
		user.setMobileNo("9779798809");
		user.setCity("BBSR");
		user.setPassword("Qwertyuiop1@");
		user.setUserId(10);
		return user;

	}
}
