package com.example.capstone.services;

import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class UserServices {
	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	public void register(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
		//Get and hash the password
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		//save the new hashed password to the user object
		user.setPassword(encodedPassword);
		//create random code to function as the verification code and save to the user object
		String randomCode = RandomString.make(64);
		user.setVerificationCode(randomCode);
		//set the user enabled flag to false in order to prevent login until the user is verified and save the user to the database
		user.setEnabled(false);
		repo.save(user);
		//run the email method by passing the created user object and URL for the site
		sendVerificationEmail(user, siteURL);
	}

	private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
		//build email message content using the passed user object and URL from the above register function
		String toAddress = user.getEmail();
		String fromAddress = "byob@buildyourownband.com";
		String senderName = "BYOB";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],"
				+ "<br>"
				+ "Please click the link below to verify your registration:"
				+ "<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">Click to VERIFY your account</a></h3>"
				+ "<br>"
				+ "You can also copy/paste this link directly into your browser:"
				+ "<br>"
				+ "[[URL]]"
				+ "<br>"
				+ "Thank you,"
				+ "<br>"
				+ "BYOB";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		content = content.replace("[[name]]", user.getUsername());
		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
		content = content.replace("[[URL]]", verifyURL);
		helper.setText(content, true);
		//send message, credentials in application.properties
		mailSender.send(message);
	}

	public boolean verify(String verificationCode) {
		//find the user with the matching verification code token in the email link
		User user = repo.findByVerificationCode(verificationCode);
		//if a user with the code isn't found or the user is already enabled, fail the verification
		if (user == null || user.isEnabled()) {
			return false;
		} else {
			//if the user is valid and the code matches, remove the code and enable the user, and save to the database and return true so login continues
			user.setVerificationCode(null);
			user.setEnabled(true);
			repo.save(user);
			return true;
		}
	}
}
