package com.mindtree.ticketshere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticketshere.dto.OtpAndEmail;
import com.mindtree.ticketshere.entity.User;
import com.mindtree.ticketshere.service.impl.ForgotPasswordService;

/**
 * 
 * @author Mohd Adil , This class act as controller for forgot password.
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordService forgotPasswordService;

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> forgotPassword(@RequestBody User user) {
		if (forgotPasswordService.isPresent(user)) {
			forgotPasswordService.sendMail(user);
			return new ResponseEntity<>("found", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Not found", HttpStatus.OK);
}

	@RequestMapping(value = "/verifyOtp", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> forgotPasswordVerify(@RequestBody OtpAndEmail otpAndEmail) {
		return new ResponseEntity<>(forgotPasswordService.verifyOtp(otpAndEmail), HttpStatus.OK);

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> changePassword(@RequestBody User user) {
		return new ResponseEntity<>(forgotPasswordService.updatePassword(user), HttpStatus.OK);

	}
}
