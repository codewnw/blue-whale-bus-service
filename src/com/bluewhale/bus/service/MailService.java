package com.bluewhale.bus.service;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	private UserVerficationService userVerficationService;

	private String fromAddress;

	private String userName;

	private String password;

	private String subject;

	private String body;

	public MailService() {
		userVerficationService = new UserVerficationServiceImpl();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("email", Locale.US);
		this.fromAddress = resourceBundle.getString("fromAddress");
		this.userName = resourceBundle.getString("username");
		this.password = resourceBundle.getString("password");
		this.subject = resourceBundle.getString("subject");
		this.body = resourceBundle.getString("body");
	}

	public void send(String toAddress) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		// Previously it was 25

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddress));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			message.setSubject(subject + " Verify your email address");
			message.setText(body + "Your email verification OTP: " + userVerficationService.create(toAddress));

			System.out.println("----\nSending email...");
			Transport.send(message);
			System.out.println("Email sent!!!\n----");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
