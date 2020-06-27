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

@WebServlet(urlPatterns = { "/login", "/verify", "/forgot", "/resetpassword" })
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
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Login login = new Login();
			login.setUnsername(username);
			login.setPassword(new Password(password));
			String status = loginService.checkStatus(login);
			if (status.equals("Verified")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				if(StringUtils.isNotBlank(firstName)) {
					session.setAttribute("firstName", firstName);
				}
				if(StringUtils.isNotBlank(lastName)) {
					session.setAttribute("lastName", lastName);
				}
				response.sendRedirect("profile.jsp");
			} else if (status.equals("Not Verified")) {
				response.sendRedirect("verify.jsp");
			} else if (status.equals("Blocked"))
				response.sendRedirect("index.jsp?msg=Your account has been blocked. Please contact Admin.");
			else {
				response.sendRedirect("login.jsp");
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
				request.getRequestDispatcher("reset-password.jsp").forward(request, response);
			}

		} else if (uri.contains("resetpassword")) {

			System.out.println("Reset Password Section");

			String username = (String) request.getParameter("emailId");
			String password = (String) request.getParameter("password");
			String otp = (String) request.getParameter("otp");

			Password changedPassword=new Password(password);
			userVerficationService = new UserVerficationServiceImpl();

			if (userVerficationService.verify(username, otp)) {
				System.out.println(" OTP Verification Successful ");
				userVerficationService.resetPassword(username, changedPassword.getSecuredPassword());
				userVerficationService.delete(username);
				String passwordResetString="Password Reset is Successful. Login to continue !";
				request.setAttribute("resetPasswordSuccessfulMsg", passwordResetString);
				request.getRequestDispatcher("login.jsp").forward(request, response);;

			} else {
				throw new RuntimeException("OTP Does not match");
			}

		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
