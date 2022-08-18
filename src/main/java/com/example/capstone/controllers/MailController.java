package com.example.capstone.controllers;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class MailController {

	public static void main(String[] args) throws IOException {
		Email from = new Email("byob@buildyourownband.com");
		String subject = "Sending with SendGrid is Fun";
		Email to = new Email("shroud2@hotmail.com");
		Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
}
