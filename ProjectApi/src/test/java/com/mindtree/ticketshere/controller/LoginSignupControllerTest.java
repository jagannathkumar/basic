package com.mindtree.ticketshere.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;
import com.mindtree.ticketshere.service.impl.LoginSignupService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { HibernateConfiguration.class, AppConfig.class })
public class LoginSignupControllerTest {
	private MockMvc mockMvc;
	
	@Mock
	LoginSignupService loginSignupService;
	
	@InjectMocks
	LoginSignupController loginSignupController;
	
	@Spy
	private User user= new User();
	@Spy
	private Organizer organizer= new Organizer();
	
	
	@BeforeClass
	public void tsetSetup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(loginSignupController).build();
		user=getUser();
		organizer=getOrganizer();
	}
	@Test
	public void testInvalidLogin() throws Exception
	{
		User userInput= new User();
		userInput.setEmail("email");
		userInput.setPassword("password");
		when(loginSignupService.isValid(userInput)).thenReturn(user);
assertEquals(user, loginSignupController.login(userInput).getBody());		
	}
	/*@Test
	public void testInvalidLogin2() throws Exception
	{
		User userInput= new User();
		userInput.setEmail("email");
		userInput.setPassword("password");
		when(loginSignupService.isValid(userInput)).thenReturn(userInput);
assertEquals(200, loginSignupController.login(userInput).getStatusCodeValue());		
	}
	@Test
	public void testInvalidLogin1() throws Exception
	{
		User userInput= new User();
		userInput.setEmail("emailad");
		userInput.setPassword("passwadaord");
		when(loginSignupService.isValid(userInput)).thenReturn(user);
		assertEquals(200, loginSignupController.login(userInput).getStatusCodeValue());
	}*/
	@Test
	public void testInvalidLoginOrganizer() throws Exception
	{
		Organizer organizerInput= new Organizer();
		organizerInput.setEmail("email");
		organizerInput.setPassword("password");
		when(loginSignupService.isValidOrganizer(organizerInput)).thenReturn(organizer);
		assertEquals(200, loginSignupController.loginOrganizer(organizerInput).getStatusCodeValue());
	}
	@Test
	public void testInvalidLoginOrganizer2() throws Exception
	{
		Organizer organizerInput= new Organizer();
		organizerInput.setEmail("email");
		organizerInput.setPassword("passwordasdad");
		when(loginSignupService.isValidOrganizer(organizerInput)).thenReturn(organizer);
		assertEquals(200, loginSignupController.loginOrganizer(organizerInput).getStatusCodeValue());
	}
	@Test
	public void testValidSignup() throws Exception
	{
		User user=new User();
		user.setCity("city");
		user.setEmail("email");
		user.setMobileNo("mobileNo");
		user.setName("name");
		user.setPassword("password");
		user.setUserId(1);
		user.setFlag("success");
		when(loginSignupService.isPresent(user)).thenReturn(false);
		when(loginSignupService.isValid(user)).thenReturn(user);
		assertEquals(200, loginSignupController.signUp2(user).getStatusCodeValue());
	}
	@Test
	public void testinValidSignup() throws Exception
	{
		User user=new User();
		user.setCity("city");
		user.setEmail("email");
		user.setMobileNo("mobileNo");
		user.setName("name");
		user.setPassword("password");
		user.setUserId(1);
		user.setFlag("success");
		when(loginSignupService.isPresent(user)).thenReturn(true);
		when(loginSignupService.isValid(user)).thenReturn(user);
		assertEquals(200, loginSignupController.signUp2(user).getStatusCodeValue());
	}
	@Test
	public void testValidSignupOrganiser() throws Exception
	{
		Organizer organizer = new Organizer();
		organizer.setEmail("email");
		organizer.setName("demo");
		organizer.setMobileNo("9876543211");
		organizer.setPassword("password");
		organizer.setFlag("success");
		when(loginSignupService.isPresentOrganizer(organizer)).thenReturn(false);
		when(loginSignupService.isValidOrganizer(organizer)).thenReturn(organizer);
		assertEquals(200, loginSignupController.signUpOrganizer(organizer).getStatusCodeValue());
	}
	@Test
	public void testInValidSignupOrganiser() throws Exception
	{
		Organizer organizer = new Organizer();
		organizer.setEmail("email");
		organizer.setName("demo");
		organizer.setMobileNo("9876543211");
		organizer.setPassword("password");
		organizer.setFlag("success");
		when(loginSignupService.isPresentOrganizer(organizer)).thenReturn(true);
		when(loginSignupService.isValidOrganizer(organizer)).thenReturn(organizer);
		assertEquals(200, loginSignupController.signUpOrganizer(organizer).getStatusCodeValue());
	}
	
	public User getUser() {
		User user= new User();
		user.setCity("city");
		user.setEmail("email");
		user.setMobileNo("mobileNo");
		user.setName("name");
		user.setPassword("password");
		user.setUserId(1);
		user.setFlag("success");
		return user;
	}
	
	public Organizer getOrganizer() {
		Organizer organizer = new Organizer();
		organizer.setEmail("email");
		organizer.setName("demo");
		organizer.setMobileNo("9876543211");
		organizer.setPassword("password");
		organizer.setFlag("success");
		return organizer;
		
	}
	

}
