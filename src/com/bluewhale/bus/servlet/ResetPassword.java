package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluewhale.bus.service.UserVerficationService;
import com.bluewhale.bus.service.UserVerficationServiceImpl;

@WebServlet("/resetpassword")
public class ResetPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserVerficationService userVerficationService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Reset Password Servlet");
		String username = (String) request.getParameter("emailId");
		String password = (String) request.getParameter("password");
		String otp = (String) request.getParameter("otp");

		userVerficationService = new UserVerficationServiceImpl();

		if (userVerficationService.verify(username, otp)) {
			System.out.println("Here - OTP Verification Successful");
			userVerficationService.resetPassword(username, password);
			userVerficationService.delete(username);
			response.sendRedirect("login.jsp");

		} else {
			response.sendRedirect("index.jsp");
		}

	}
}