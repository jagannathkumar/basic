package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Channels {
	@Id
	int channel_id;
	String channel_name;
	Double cost_per_month;
	
	public int getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public Double getCost_per_month() {
		return cost_per_month;
	}
	public void setCost_per_month(Double cost_per_month) {
		this.cost_per_month = cost_per_month;
	}
	@Override
	public String toString() {
		return "Channels [channel_id=" + channel_id + ", channel_name=" + channel_name + ", cost_per_month="
				+ cost_per_month + "]";
	}
	
}
