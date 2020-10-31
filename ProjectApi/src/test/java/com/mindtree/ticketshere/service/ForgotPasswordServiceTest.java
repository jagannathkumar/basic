package com.mindtree.ticketshere.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.configuration.WebInitializer;
import com.mindtree.ticketshere.dao.impl.ForgotPasswordDaoImpl;
import com.mindtree.ticketshere.dto.OtpAndEmail;
import com.mindtree.ticketshere.entity.User;
import com.mindtree.ticketshere.service.impl.ForgotPasswordService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class, WebInitializer.class })
public class ForgotPasswordServiceTest {
	@Mock
	private ForgotPasswordDaoImpl forgotpasswordDao;
	@InjectMocks
	private ForgotPasswordService forgotPasswordService;
	@Spy
	private User user;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = getUser();
	}

	@Test
	public void isPresentTrue() {
		User userInput = new User();
		userInput.setEmail("demo@mail.com");
		when(forgotpasswordDao.isPresent(userInput)).thenReturn(true);
		assertEquals(true, forgotPasswordService.isPresent(userInput));
	}

	@Test
	public void isPresentFalse() {
		User userInput = new User();
		userInput.setEmail("demo@mail.com");
		when(forgotpasswordDao.isPresent(userInput)).thenReturn(false);
		assertEquals(false, forgotPasswordService.isPresent(userInput));
	}

	@Test
	public void updatePasswordTest() {
		User userInput = new User();
		userInput.setEmail("demo@mail.com");
		when(forgotpasswordDao.updatePsword(userInput)).thenReturn("Password changed");
		assertEquals("Password changed", forgotPasswordService.updatePassword(userInput));
	}

//	@Test
//	public void verifyOtpTest() {
//		OtpAndEmail otpAndEmail = new OtpAndEmail();
//		otpAndEmail.setEmail("demo@mail.com");
//		otpAndEmail.setOtp("6789");
//		when(forgotpasswordDao.getUserWithOtp(otpAndEmail.getEmail())).thenReturn(user);
//		assertEquals("Valid", forgotPasswordService.verifyOtp(otpAndEmail));
//	}
	@Test
	public void verifyOtpTestInvalid() {
		OtpAndEmail otpAndEmail = new OtpAndEmail();
		otpAndEmail.setEmail("demo@mail.com");
		otpAndEmail.setOtp("6749");
		when(forgotpasswordDao.getUserWithOtp(otpAndEmail.getEmail())).thenReturn(user);
		assertEquals("Wrong OTP", forgotPasswordService.verifyOtp(otpAndEmail));
	}
	private User getUser() {
		User user = new User();
		user.setName("Demo");
		user.setEmail("demo@mail.com");
		user.setMobileNo("9779798809");
		user.setCity("BBSR");
		user.setPassword("Qwertyuiop1@");
		user.setUserId(10);
		user.setOtp("6789");
		return user;

	}

}
