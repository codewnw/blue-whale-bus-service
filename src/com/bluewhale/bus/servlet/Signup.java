package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluewhale.bus.model.Login;
import com.bluewhale.bus.model.Password;
import com.bluewhale.bus.model.User;
import com.bluewhale.bus.service.LoginService;
import com.bluewhale.bus.service.LoginServiceImpl;
import com.bluewhale.bus.service.MailService;
import com.bluewhale.bus.service.UserService;
import com.bluewhale.bus.service.UserServiceImpl;

@WebServlet("/signup")
public class Signup extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(Signup.class);
	private static final long serialVersionUID = 1L;

	private MailService mailService;

	private LoginService loginService;

	private UserService userService;

	public Signup() {
		userService = new UserServiceImpl();
		loginService = new LoginServiceImpl();
		mailService = new MailService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("Inside Class :" + this.getClass().getSimpleName());

		response.sendRedirect("signup.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("Inside Class :" + this.getClass().getSimpleName());

		String username = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		userService.create(user);

		Login login = new Login();

		login.setUnsername(username);
		login.setPassword(new Password(password));
		login.setType("Customer");
		login.setStatus("Not Verified");
		loginService.create(login);

		// Async Email
		new Thread(() -> mailService.send(username)).start();

		response.sendRedirect("index.jsp");
	}

}
