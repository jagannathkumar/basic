package com.mindtree.ticketshere.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.impl.FeedbackDaoImpl;
import com.mindtree.ticketshere.entity.Feedback;

@Service
@Transactional
public class FeedbackServiceImpl {
	@Autowired
	FeedbackDaoImpl feedbackDao;
	 public String submitFeedback(Feedback feedback)
	 {
		 return feedbackDao.submitFeedback(feedback);
	 }

}
