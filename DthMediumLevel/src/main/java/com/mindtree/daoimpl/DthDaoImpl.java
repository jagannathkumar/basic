package com.mindtree.daoimpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.DthDao;
import com.mindtree.entity.Channels;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Subscription_Channel;


@Component
@SuppressWarnings("unchecked")
public class DthDaoImpl implements DthDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSubscription(Subscription_Channel sc)
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Customer where subscriber_id=?");
		q.setParameter(0, sc.getSubscriber_id());
		List<Customer> li=q.getResultList();
		if(li.size()!=0)
		{
			session.save(sc);
			return true;
		}
		else
			return false;
	}
	
	@Transactional
	public int getChannelId(String channel)
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("select ch.channel_id from Channels ch where ch.channel_name in(:chname)");
		q.setParameter("chname", channel);
		
		List<Integer> lt=q.getResultList();
		
		@SuppressWarnings("rawtypes")
		Iterator it=lt.iterator();
		return (Integer) it.next();
	}
	
	@Transactional
	public int unsubscribe(int subid,String channel)
	{
		int a=0;
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("delete from Subscription_Channel where subscriber_id=? and channel_id in (select channel_id from Channels where channel_name=?)");
		q.setParameter(0, subid);
		q.setParameter(1, channel);
		a=q.executeUpdate();
		return a;
	}
	
	@Transactional
	public List<Channels> getAllChannels()
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("select channel_name from Channels");
		return q.getResultList();
	}
	
	@Transactional
	public List<Object> getDetails(int subid)
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Channels where channel_id in (select channel_id from Subscription_Channel where subscriber_id=?)");
		q.setParameter(0, subid);
		return q.getResultList();
	}
	
	@Transactional
	public List<Object> getCustomerDetails(int subid)
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Customer where subscriber_id=?");
		q.setParameter(0, subid);
		return q.getResultList();
	}
	
	@Transactional
	public boolean checkSubcription(int chid,int subid)
	{
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Subscription_Channel where channel_id=? and subscriber_id=?");
		q.setParameter(0, chid);
		q.setParameter(1, subid);
		if(q.getResultList().isEmpty())
			return false;
		return true;
	}
}
