package com.mindtree.ticketshere.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.impl.ForgotPasswordDaoImpl;
import com.mindtree.ticketshere.dto.OtpAndEmail;
import com.mindtree.ticketshere.entity.User;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
@Transactional
public class ForgotPasswordService {
	@Autowired
	ForgotPasswordDaoImpl forgotpasswordDao;

	long startTime;

	public boolean isPresent(User user) {
		return forgotpasswordDao.isPresent(user);
	}

	public String sendMail(User user) {
		String otp = null;
		String fromEmail = "heretickets185@gmail.com";

		final String password = "Tickets_185";

		final String userName = "heretickets185@gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));

			double num = Math.ceil(Math.random() * 10000);
			if (num < 1000)
				num = num + 1000;
			if (num > 9999)
				num = num / 10;
			System.out.println((int) num);
			otp = (int) num + "";

			message.setText(
					"We have sent you this email in response to your request to reset your password on Tickets Here.\nTo reset your password enter the OTP "
							+ otp
							+ " in the required field.\nWe recommend that you keep your password secure and not share it with anyone.\n If you need help, or you have any other questions, feel free to email heretickets185@gmail.com\nNote:This OTP is valid for only 15 minutes.");

			message.setSubject("Reset your password");

			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Succesful");
		String startTimeOtp = String.valueOf(System.currentTimeMillis());
		forgotpasswordDao.updateOtpStartTime(user, otp, startTimeOtp);
		return user.getEmail();

	}

	public String verifyOtp(OtpAndEmail otpAndEmail) {
		User user = new User();
		user = forgotpasswordDao.getUserWithOtp(otpAndEmail.getEmail());
		if (user.getOtp().equalsIgnoreCase(otpAndEmail.getOtp())) {
			if ((System.currentTimeMillis() - Long.valueOf(user.getOtpStartTime())) < 900000)
				return "Valid";
			else
				return "OTP is no longer valid";
		} else
			return "Wrong OTP";
	}
public String updatePassword(User user)
{
	return forgotpasswordDao.updatePsword(user);
	}

}
