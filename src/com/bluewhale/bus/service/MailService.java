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

import com.bluewhale.bus.model.Booking;

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
	
	public void sendTicket(String toAddress, Booking booking) {

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
			message.setSubject(subject + " Ticket Details");
			message.setText(body + "Congratulations. Your seat has been booked !!"
					+ "\nBelow are your ticket details.\n---------------------------------------"
					+ "\nBooking Id : "+booking.getbId()
				+"\nTravel Date : "+booking.getTravelDate()
				+"\nPlace of Origin : "+booking.getFromPlace()
				+"\nPlace of Destination : "+booking.getToPlace()
				+"\nSeats Booked : "+booking.getSeatNo()
				+"\nBus No : "+booking.getBusId());

			System.out.println("----\nSending Ticket email...");
			Transport.send(message);
			System.out.println("Ticket Email sent!!!\n----");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
