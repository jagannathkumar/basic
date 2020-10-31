package com.mindtree.ticketshere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	private int feedbackId;
	private String name;
	private String email;
	@Type(type = "text")
	private String feedbackComments;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedbackComments() {
		return feedbackComments;
	}
	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}
	

	
}
