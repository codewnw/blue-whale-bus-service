package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluewhale.bus.service.UserVerficationService;
import com.bluewhale.bus.service.UserVerficationServiceImpl;

@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserVerficationService userVerficationService;

	public ForgotPassword() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("forgot.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Forgot Password Servlet");
		String username = (String) request.getParameter("emailId");
		userVerficationService = new UserVerficationServiceImpl();
		if (userVerficationService.forgotPassword(username)) {

			// If User Exists then send Redirect
			request.setAttribute("emailId", username);
			request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}
}