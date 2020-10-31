package com.mindtree.ticketshere.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;



@Entity
public class EventDetails {
	@Id
	private int eventId;
	private String eventName;
	private String eventDuration;
	@Type(type = "text")
	private String eventDescription;
	private String eventBanner;
	private String eventTrailor;
	private String releaseDate;

	private String eventType;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@JoinColumn(referencedColumnName = "eventId")
	private List<VenueDetails> venueDetails;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@JoinColumn(referencedColumnName = "eventId")
	private List<TimingsSlot> timingsSlot;
	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public List<TimingsSlot> getTimingsSlot() {
		return timingsSlot;
	}

	public void setTimingsSlot(List<TimingsSlot> timingsSlot) {
		this.timingsSlot = timingsSlot;
	}

	public List<VenueDetails> getVenueDetails() {
		return venueDetails;
	}

	public void setVenueDetails(List<VenueDetails> venueDetails) {
		this.venueDetails = venueDetails;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventBanner() {
		return eventBanner;
	}

	public void setEventBanner(String eventBanner) {
		this.eventBanner = eventBanner;
	}

	public String getEventTrailor() {
		return eventTrailor;
	}

	public void setEventTrailor(String eventTrailor) {
		this.eventTrailor = eventTrailor;
	}
	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public EventDetails() {
		super();
	
	}

}
