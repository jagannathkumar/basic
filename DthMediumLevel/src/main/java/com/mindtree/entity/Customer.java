package com.mindtree.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {

	@Id
	int subscriber_id;
	long registered_mobile;
	String first_name;
	String last_name;
	
	public int getSubscriber_id() {
		return subscriber_id;
	}
	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	public long getRegistered_mobile() {
		return registered_mobile;
	}
	public void setRegistered_mobile(long registered_mobile) {
		this.registered_mobile = registered_mobile;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
}
