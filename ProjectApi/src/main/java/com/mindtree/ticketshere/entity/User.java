package com.mindtree.ticketshere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String name;
	
	private String email;
	private String mobileNo;
	private String city;
	private String password;
	private String otpStartTime;
	private String otp;
	@Transient
	private String flag;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", city="
				+ city + ", password=" + password + ", otpStartTime=" + otpStartTime + ", otp=" + otp + ", flag=" + flag
				+ "]";
	}

}
