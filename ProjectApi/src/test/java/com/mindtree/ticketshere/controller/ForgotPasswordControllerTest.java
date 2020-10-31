package com.mindtree.ticketshere.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.ticketshere.configuration.AppConfig;
import com.mindtree.ticketshere.configuration.HibernateConfiguration;
import com.mindtree.ticketshere.dto.OtpAndEmail;
import com.mindtree.ticketshere.service.impl.ForgotPasswordService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class , AppConfig.class})
public class ForgotPasswordControllerTest {
	private MockMvc mockMvc;
	@Mock
	@Autowired
	ForgotPasswordService forgotPasswordService;
	@InjectMocks
	ForgotPasswordController forgotPasswordController;
	@BeforeClass
	public void tsetSetup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(forgotPasswordController).build();
	}
	@Test
	public void test3() throws Throwable
	{
		OtpAndEmail otpAndEmail = new OtpAndEmail();
		otpAndEmail.setEmail("email");
		otpAndEmail.setOtp("1234");
		when(forgotPasswordService.verifyOtp(otpAndEmail)).thenReturn("Valid");
		assertEquals(200,forgotPasswordController.forgotPasswordVerify(otpAndEmail).getStatusCodeValue());


	}
	@Test
	public void test1() throws Throwable
	{
		OtpAndEmail otpAndEmail = new OtpAndEmail();
		otpAndEmail.setEmail("email");
		otpAndEmail.setOtp("1234");
		when(forgotPasswordService.verifyOtp(otpAndEmail)).thenReturn("OTP is no longer valid");
		assertEquals(200,forgotPasswordController.forgotPasswordVerify(otpAndEmail).getStatusCodeValue());


	}
	@Test
	public void test2() throws Throwable
	{
		OtpAndEmail otpAndEmail = new OtpAndEmail();
		otpAndEmail.setEmail("email");
		otpAndEmail.setOtp("1234");
		when(forgotPasswordService.verifyOtp(otpAndEmail)).thenReturn("Wrong OTP");
		assertEquals(200,forgotPasswordController.forgotPasswordVerify(otpAndEmail).getStatusCodeValue());


	}
	@Test
	public void test() throws Throwable
	{
		OtpAndEmail otpAndEmail = new OtpAndEmail();
		otpAndEmail.setEmail("email");
		otpAndEmail.setOtp("1234");
		when(forgotPasswordService.verifyOtp(otpAndEmail)).thenReturn("Valid");
		assertEquals(200,forgotPasswordController.forgotPasswordVerify(otpAndEmail).getStatusCodeValue());

	}
}
