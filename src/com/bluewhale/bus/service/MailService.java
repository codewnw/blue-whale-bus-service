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

	public MailService() {
		userVerficationService = new UserVerficationServiceImpl();
	}

	public void send(String toAddr) {
		ResourceBundle rb = ResourceBundle.getBundle("email", Locale.US);
		final String userName = rb.getString("username");
		final String password = rb.getString("password");
		String fromAddr = rb.getString("from");
		String subject = rb.getString("subject");
		String text = rb.getString("text");

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddr));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddr));
			message.setSubject(subject);
			message.setText(text + " " + userVerficationService.create(toAddr));

			Transport.send(message);

			System.out.println("Sent!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
