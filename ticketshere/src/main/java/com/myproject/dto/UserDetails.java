package com.myproject.dto;
import java.util.List;

import com.myproject.entity.Address;
import com.myproject.entity.User;
/**
 * @author JK
 *
 */
public class UserDetails {
	private String userName;
	private List<String> address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
}
