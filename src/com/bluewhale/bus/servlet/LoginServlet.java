package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.bluewhale.bus.model.Login;
import com.bluewhale.bus.model.Password;
import com.bluewhale.bus.service.LoginService;
import com.bluewhale.bus.service.LoginServiceImpl;
import com.bluewhale.bus.service.UserVerficationService;
import com.bluewhale.bus.service.UserVerficationServiceImpl;

@WebServlet(urlPatterns = { "/login", "/verify", "/forgot", "/resetpassword","/changePassword" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;

	private UserVerficationService userVerficationService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
		userVerficationService = new UserVerficationServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		if (uri.contains("forgot")) {
			response.sendRedirect("forgot.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			Login login = new Login();
			login.setUnsername(username);
			login.setPassword(new Password(password));
			String status = loginService.checkStatus(login);
			if (StringUtils.isNotBlank(status)) {
				if (status.equals("Verified")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("username", username);
					response.sendRedirect("profile.jsp");
				} else if (status.equals("Not Verified")) {
					response.sendRedirect("verify.jsp");
				} else if (status.equals("Blocked"))
					response.sendRedirect("index.jsp?msg=Your account has been blocked. Please contact Admin.");
			}
			else {
				response.sendRedirect("login.jsp?errorMessage=Not matching email Id and Password. Please try again !");
			}
		} else if (uri.contains("verify")) {
			String username = request.getParameter("email");
			String otp = request.getParameter("otp");
			boolean isVerified = userVerficationService.verify(username, otp);
			if (isVerified) {
				Login login = new Login();
				login.setUnsername(username);
				login.setStatus("Verified");
				loginService.update(login);
				userVerficationService.delete(username);
			}

			response.sendRedirect("index.jsp?msg=Verification Successfull !");

		} else if (uri.contains("forgot")) {

			System.out.println("Forgot Password Servlet");
			String username = (String) request.getParameter("emailId");
			userVerficationService = new UserVerficationServiceImpl();
			if (userVerficationService.forgotPassword(username)) {

				// If User Exists then send Redirect
				request.setAttribute("emailId", username);
				request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
			}else {
				System.out.println("Entered email id does not exit.");
				String errorMessage="Entered email id does not exist. Please enter your registered email-id.";
				response.sendRedirect("forgot.jsp?errorMessage="+errorMessage);
			}
		}else if (uri.contains("changePassword")) {

			System.out.println("Forgot Password Section");

			String username = (String) request.getParameter("emailId");

			System.out.println("username : "+username);
			Password changedPassword=new Password(request.getParameter("newPassword"));
			userVerficationService = new UserVerficationServiceImpl();

			if (userVerficationService.isExistingUser(username)) {
				System.out.println("User Exists !");
				userVerficationService.resetPassword(username, changedPassword.getSecuredPassword());
				String passwordResetString = "Password Reset is Successful !!";
				response.sendRedirect("logout.jsp?resetPasswordSuccessfulMsg=" + passwordResetString);
			} else {
				System.out.println("Error Resetting Password. Entered email id does not exits.");
				String errorMessage="Error Resetting Password. Please enter your registered email-id...";
				response.sendRedirect("forgot-password.jsp?errorMessage="+errorMessage);
			}
		}
		else if (uri.contains("resetpassword")) {

			System.out.println("Reset Password Section");

			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("username");

			Password oldPasswd=new Password(request.getParameter("oldPassword"));
			Password changedPassword=new Password(request.getParameter("newPassword"));
			userVerficationService = new UserVerficationServiceImpl();

			if (userVerficationService.verifyOldPassword(username, oldPasswd.getSecuredPassword())) {
				System.out.println("Password Verification Successful ");
				userVerficationService.resetPassword(username, changedPassword.getSecuredPassword());
				userVerficationService.delete(username);
				session.invalidate();
				String passwordResetString="Password Reset is Successful. You have been logged out !!";
				response.sendRedirect("logout.jsp?resetPasswordSuccessfulMsg="+passwordResetString);
			} else {
				System.out.println("Error Resetting Password. Old password does not match.");
				String errorMessage="Error Resetting Password. Old password does not match. Please try again...";
				response.sendRedirect("reset-password.jsp?errorMessage="+errorMessage);
			}

		} else {
			response.sendRedirect("index.jsp");
		}
	}
}