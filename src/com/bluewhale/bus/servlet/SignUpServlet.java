package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluewhale.bus.dao.DaoJdbc;
import com.bluewhale.bus.dao.DaoJdbcImpl;
import com.bluewhale.bus.model.Customer;
import com.bluewhale.bus.model.User;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoJdbc daoJdbc;
	public SignUpServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Sign Up Servlet");
		daoJdbc=new DaoJdbcImpl();
		User user=(User) request.getAttribute("cust");
		System.out.println(user);
		daoJdbc.create(user);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/SignUpSuccessful.jsp");
		rd.forward(request, response);
		
	}

}
