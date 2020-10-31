package com.mindtree.ticketshere.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.impl.TicketsHereDaoImpl;
import com.mindtree.ticketshere.entity.EventDetails;
import com.mindtree.ticketshere.entity.Events;
import com.mindtree.ticketshere.entity.Ticket;

@Service
@Transactional
public class TicketsHereServiceImpl {
	
	@Autowired
	TicketsHereDaoImpl ticketshereDao;
	
	public List<EventDetails> getEvent(String eventName)
	{
		return ticketshereDao.getEvent(eventName);
	}
	
	public List<Events> getSpecificEvent(String eventName)
	{
		return ticketshereDao.getSpecificEvent(eventName);
	}
	
	public String updateTicket(Ticket ticket) {
		return ticketshereDao.updateTicket(ticket);
	}
	public String checkTicket(Ticket ticket) {
		return ticketshereDao.checkTicket(ticket);
	}
	public void sentMail(Ticket ticket) 
	{
		String fromEmail = "heretickets185@gmail.com";
		final String password = "Tickets_185";
		String toEmail = ticket.getEmail();
		final String userName = "heretickets185@gmail.com";
		
		//System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "25"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
	            //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		try {
		Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setText("Your Ticket Id is: "+ticket.getBookingId()+"");
			message.setSubject("subject");
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

}
