package com.mindtree.ticketshere.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.configuration.WebInitializer;
import com.mindtree.ticketshere.dao.impl.FeedbackDaoImpl;
import com.mindtree.ticketshere.entity.Feedback;
import com.mindtree.ticketshere.service.impl.FeedbackServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class, WebInitializer.class })

public class FeedbackServiceTest {
	@Mock
	FeedbackDaoImpl feedbackDao;
	
	@InjectMocks
	FeedbackServiceImpl feedbackService;
	
	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	public void submitFeedbackTest()
	{	Feedback feedback= new Feedback();
	feedback.setEmail("demo@mail.com");
	feedback.setName("demo");
	feedback.setFeedbackComments("Hi It's Working");
		when(feedbackDao.submitFeedback(feedback)).thenReturn("success");
		assertEquals("success",feedbackService.submitFeedback(feedback));
	}
	}
