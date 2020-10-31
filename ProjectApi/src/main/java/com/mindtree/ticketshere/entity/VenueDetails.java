package com.mindtree.ticketshere.entity;




import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class VenueDetails {

	@Id
	private int venueId;
	private String venueName;
	private String venueTiming;
	private String venueSeat;
	private String venueBanner;
	private String venueReviews;
	private String venueLanguage;
	

	public String getVenueLanguage() {
		return venueLanguage;
	}

	public void setVenueLanguage(String venueLanguage) {
		this.venueLanguage = venueLanguage;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueTiming() {
		return venueTiming;
	}

	public void setVenueTiming(String venueTiming) {
		this.venueTiming = venueTiming;
	}

	public String getVenueSeat() {
		return venueSeat;
	}

	public void setVenueSeat(String venueSeat) {
		this.venueSeat = venueSeat;
	}

	public String getVenueBanner() {
		return venueBanner;
	}

	public void setVenueBanner(String venueBanner) {
		this.venueBanner = venueBanner;
	}

	public String getVenueReviews() {
		return venueReviews;
	}

	public void setVenueReviews(String venueReviews) {
		this.venueReviews = venueReviews;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public VenueDetails(int venueId, String venueName, String venueTiming, String venueSeat, String venueBanner,
			String venueReviews, String venueLanguage) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueTiming = venueTiming;
		this.venueSeat = venueSeat;
		this.venueBanner = venueBanner;
		this.venueReviews = venueReviews;
		this.venueLanguage = venueLanguage;
	}

	public VenueDetails() {
		super();
	}

	@Override
	public String toString() {
		return "VenueDetails [venueId=" + venueId + ", venueName=" + venueName + ", venueTiming=" + venueTiming
				+ ", venueSeat=" + venueSeat + ", venueBanner=" + venueBanner + ", venueReviews=" + venueReviews
				+ ", venueLanguage=" + venueLanguage + "]";
	}

}
