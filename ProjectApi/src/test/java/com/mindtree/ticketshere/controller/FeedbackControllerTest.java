package com.mindtree.ticketshere.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.entity.Feedback;
import com.mindtree.ticketshere.service.impl.FeedbackServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class , AppConfig.class})
public class FeedbackControllerTest {
	private MockMvc mockMvc;
	
	@Mock
	FeedbackServiceImpl feedbackService;
	@InjectMocks
	FeedbackController feedbackController;
	@BeforeClass
	public void tsetSetup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(feedbackController).build();
	}
	@Test
	public void test() throws Throwable
	{ Feedback feedback= new Feedback();
	feedback.setEmail("email");
	feedback.setFeedbackComments("feedbackComments");
	feedback.setName("name");
		when(feedbackService.submitFeedback(feedback)).thenReturn("success");
		mockMvc.perform(post("/submitFeedback").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

}
