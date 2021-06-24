/**
 * 
 */
package com.spring.practice.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.springpractice.entity.Address;
import com.spring.practice.springpractice.entity.User;
import com.spring.practice.springpractice.service.simpl.AddressService;
import com.spring.practice.springpractice.service.simpl.UserService;

/**
 * @author JK
 *
 */
@RestController
public class UserOperation {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam("userId") int id) {
		return userService.showUser(id);
	}
	@PostMapping("/saveAddr")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
}
