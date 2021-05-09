package com.myproject.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.myproject.UserDetails;

public class TestJunit {
	@Test
	public void getName() {
		UserDetails ud= new UserDetails();
		ud.setName("User0");
		assertEquals("User0",ud.getName());
	}
}
