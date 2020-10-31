package com.mindtree.ticketshere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.Feedback;
import com.mindtree.ticketshere.service.impl.FeedbackServiceImpl;

/**
 * 
 * @author Mohd Adil , This class act as controller for Cancelling a ticket.
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class FeedbackController {
	@Autowired
	FeedbackServiceImpl feedbackService;
	
	
	@RequestMapping(value = "/submitFeedback", method = RequestMethod.POST)
	public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
		
			return new ResponseEntity<>(feedbackService.submitFeedback(feedback), HttpStatus.OK);
		}	
	}
