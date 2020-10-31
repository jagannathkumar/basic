/**
 * 
 */
package com.mindtree.ticketshere.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.entity.Ticket;
import com.mindtree.ticketshere.service.impl.CancelBookingServiceImpl;

/**
 * @author M1044325
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { HibernateConfiguration.class, AppConfig.class })
public class CancelBookingControllerTest {
	private MockMvc mockMvc;

	@Mock
	CancelBookingServiceImpl cancelBookingService;

	@InjectMocks
	CancelBookingController cancelBookingController;

	@BeforeClass
	public void tsetSetup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cancelBookingController).build();

	}
	@Test
	public void testValidisPresent()
	{
		Ticket ticket=new Ticket();
		ticket.setBookingId("tick011");
		when(cancelBookingService.isPresent("tick011")).thenReturn(true);
		assertEquals(200, cancelBookingController.cancelBooking("tick011").getStatusCodeValue());
	}
	@Test
	public void testinValidisPresent()
	{
		Ticket ticket=new Ticket();
		ticket.setBookingId("tick011");
		when(cancelBookingService.isPresent("tick011")).thenReturn(false);
		assertEquals(200, cancelBookingController.cancelBooking("tick011").getStatusCodeValue());
	}
	@Test
	public void testValidGetBookingId()
	{
		Ticket ticket=new Ticket();
		ticket.setBookingId("tick011");
		//when(cancelBookingService.isPresent("tick011")).thenReturn(true);
		assertEquals(200, cancelBookingController.getBookings("tick011").getStatusCodeValue());
	}
}
