package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Channels;
import com.mindtree.entity.Subscription_Channel;

public interface DthDao {
	public boolean addSubscription(Subscription_Channel sc);
	public int getChannelId(String channel);
	public int unsubscribe(int subid, String ch);
	public List<Channels> getAllChannels();
	public List<Object> getDetails(int subid);
	public List<Object> getCustomerDetails(int subid);
	public boolean checkSubcription(int chid,int subid);
}
