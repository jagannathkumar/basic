package com.mindtree.ticketshere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;
import com.mindtree.ticketshere.service.impl.LoginSignupService;
/**
 * 
 * @author Mohd Adil , This class act as controller for login/signup.
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class LoginSignupController {
	@Autowired
	LoginSignupService ticketservice;
	
	String flag ="failure";
	String flagsuccess="success";

	@RequestMapping(value = "/signup2", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> signUp2(@RequestBody User user) {
		if (ticketservice.isPresent(user))
		{ 
			user.setFlag(flag);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			ticketservice.insert(user);
			user.setFlag(flagsuccess);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> login(@RequestBody User user) {
		if ((ticketservice.isValid(user).getFlag().equals(flag))) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else
		{
			return new ResponseEntity<>(ticketservice.isValid(user), HttpStatus.OK);
	}}

	@RequestMapping(value = "/signupOrganizer", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Organizer> signUpOrganizer(@RequestBody Organizer organizer) {
		if (ticketservice.isPresentOrganizer(organizer)) {
			organizer.setFlag(flag);
			return new ResponseEntity<>(organizer, HttpStatus.OK);
		} else {
			ticketservice.insertOrganizer(organizer);
			organizer.setFlag(flagsuccess);
			return new ResponseEntity<>(organizer, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/loginOrganizer", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Organizer> loginOrganizer(@RequestBody Organizer organizer) {
		if ((ticketservice.isValidOrganizer(organizer).getFlag().equals(flag))) {
			return new ResponseEntity<>(organizer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ticketservice.isValidOrganizer(organizer), HttpStatus.OK);
	}}
}