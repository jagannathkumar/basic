package com.mindtree.ticketshere.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.mindtree.ticketshere.dao.SearchDao;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.TimingsSlot;
import com.mindtree.ticketshere.entity.VenueDetails;
import com.mindtree.ticketshere.service.impl.SearchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class,AppConfig.class})
public class SearchServiceTest {
	
	@Mock
	SearchDao searchDao;

	@InjectMocks
	SearchServiceImpl searchService;

	@Spy
	public List<EventDetails> get = new ArrayList<EventDetails>();
	String str;

	@BeforeClass
	public void before() {
		MockitoAnnotations.initMocks(this);
		this.get = this.getParticularEvents();
	}

	public List<EventDetails> getParticularEvents() {
		ArrayList<EventDetails> list = new ArrayList<>();
		List<TimingsSlot> tslotList = new ArrayList<>();
		List<VenueDetails> vlist = getVenue();

		EventDetails events = new EventDetails();

		events.setEventBanner("eventBanner");
		events.setEventDescription("eventDescription");
		events.setEventDuration("eventDuration");
		events.setEventId(1);
		events.setEventName("eventName");
		events.setEventTrailor("eventTrailor");
		events.setEventType("eventType");
		events.setTimingsSlot(tslotList);
		events.setVenueDetails(vlist);

		list.add(events);
		return list;
	}

	public List<VenueDetails> getVenue() {
		List<VenueDetails> list = new ArrayList<>();
		VenueDetails venueDetails = new VenueDetails();
		venueDetails.setVenueBanner("banner");
		venueDetails.setVenueId(2);
		venueDetails.setVenueLanguage("language");
		venueDetails.setVenueName("inox");
		venueDetails.setVenueReviews("review");
		venueDetails.setVenueSeat("11");
		venueDetails.setVenueTiming("timing");
		list.add(venueDetails);
		return list;
	}

	@Test
	public void getAllEventTest() {
		try {
			when(this.searchDao.getAllEvents()).thenReturn(this.get);
		} catch (Exception e) {
		}

		assertEquals(1, this.searchService.getAllEvents().size());
	}

	@Test
	public void getParticularEventTest() {
		try {
			when(this.searchDao.getAllVenue()).thenReturn(getVenue());
			when(this.searchDao.getAllEvents()).thenReturn(this.get);
		} catch (Exception e) {
		}

		assertEquals(0, this.searchService.getParticularEvent("inox").size());
		assertEquals(0, this.searchService.getParticularEvent("eventType").size());
		assertEquals(1, this.searchService.getParticularEvent("eventName").size());
		assertEquals(1, this.searchService.getParticularEvent("event").size());
	}

}
