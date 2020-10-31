package com.mindtree.ticketshere.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Events {
	@Id
	private int eventId;
	private String eventTitle;
	private String eventDirector;
	@Type(type = "text")
	private String eventCast;
	private String eventGenre;
	@Type(type = "text")
	private String eventProductionHouse;
	private String eventPoster;
	private String eventLanguage;
    private String eventLanguage1;
    private String eventLanguage2;
    
    public Events() {
		super();
		
	}
	
	public String getEventLanguage() {
		return eventLanguage;
	}

	public void setEventLanguage(String eventLanguage) {
		this.eventLanguage = eventLanguage;
	}

	public String getEventPoster() {
		return eventPoster;
	}

	public void setEventPoster(String eventPoster) {
		this.eventPoster = eventPoster;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDirector() {
		return eventDirector;
	}

	public void setEventDirector(String eventDirector) {
		this.eventDirector = eventDirector;
	}

	public String getEventCast() {
		return eventCast;
	}

	public void setEventCast(String eventCast) {
		this.eventCast = eventCast;
	}

	public String getEventGenre() {
		return eventGenre;
	}

	public void setEventGenre(String eventGenre) {
		this.eventGenre = eventGenre;
	}

	public String getEventProductionHouse() {
		return eventProductionHouse;
	}

	public void setEventProductionHouse(String eventProductionHouse) {
		this.eventProductionHouse = eventProductionHouse;
	}
	public String getEventLanguage1() {
		return eventLanguage1;
	}

	public void setEventLanguage1(String eventLanguage1) {
		this.eventLanguage1 = eventLanguage1;
	}

	public String getEventLanguage2() {
		return eventLanguage2;
	}

	public void setEventLanguage2(String eventLanguage2) {
		this.eventLanguage2 = eventLanguage2;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventTitle=" + eventTitle + ", eventDirector=" + eventDirector
				+ ", eventCast=" + eventCast + ", eventGenre=" + eventGenre + ", eventProductionHouse="
				+ eventProductionHouse + ", eventPoster=" + eventPoster + ", eventLanguage=" + eventLanguage
				+ ", eventLanguage1=" + eventLanguage1 + ", eventLanguage2=" + eventLanguage2 + "]";
	}
}
