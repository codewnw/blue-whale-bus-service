package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluewhale.bus.model.Login;
import com.bluewhale.bus.service.LoginService;
import com.bluewhale.bus.service.LoginServiceImpl;
import com.bluewhale.bus.service.UserVerficationService;
import com.bluewhale.bus.service.UserVerficationServiceImpl;

@WebServlet(urlPatterns = { "/login", "/verify" })
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
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			String status = loginService.checkStatus(username, password);
			if (status.equals("Verified")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				response.sendRedirect("profile.jsp");
			} else if (status.equals("Not Verified")) {
				response.sendRedirect("verify.jsp");
			} else if (status.equals("Blocked"))
				response.sendRedirect("index.jsp?msg=Your account has been bloacked. Please contact Admin.");
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
			response.sendRedirect("index.jsp?msg=Verification successfull!");
		} else {
			response.sendRedirect("index.jsp");
		}

	}

}
