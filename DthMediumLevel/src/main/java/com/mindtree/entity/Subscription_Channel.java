package com.mindtree.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription_Channel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String subscription_date;
	int channel_id;
	int subscriber_id;
	
	public int getId() {
		return id;
	}
	
	public String getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(String subscription_date) {
		this.subscription_date = subscription_date;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	public int getSubscriber_id() {
		return subscriber_id;
	}
	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	
}