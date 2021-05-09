/**
 * 
 */
package com.myproject.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JK
 *
 */
class User{
	public String name;
	public User(String name) {
		this.name=name;
	}
}
class Address{
	private String addressline;
	private List<User> user;
	public String getAddressline() {
		return addressline;
	}
	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
}
public class Iterateexample {

	public static void main(String[] args) {
		User u1= new User("xyz");
		User u2= new User("ppp");
		Address ad = new Address();
		ad.setAddressline("abc");
		List<User> us= new ArrayList<User>();
		us.add(u1);
		us.add(u2);
		ad.setUser(us);
		System.out.println(ad.getAddressline());
		for(User user:ad.getUser()) {
			System.out.println(user.name);
		}
		System.out.println(ad);
		
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1, "abc");
		
		HashMap<Integer,String> mp = (HashMap<Integer, String>) map.clone();
		System.out.println(mp);
	}

}
