package com.mindtree.ticketshere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Organizer {
	@Id
	@GeneratedValue
	private int organizerId;
	private String name;
	private String email;
	private String mobileNo;
	private String password;
	private String otpStartTime;
	private String otp;
	@Transient
	private String flag;
	public int getOrganizerId() {
		return organizerId;
	}
	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Organizer() {
		super();
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getOtpStartTime() {
		return otpStartTime;
	}
	public void setOtpStartTime(String otpStartTime) {
		this.otpStartTime = otpStartTime;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
}
