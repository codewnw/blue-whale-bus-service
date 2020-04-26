package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.ticketing.dao.DaoJdbc;
import com.bus.ticketing.dao.DaoJdbcImpl;
import com.bus.ticketing.model.Customer;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoJdbc daoJdbc=new DaoJdbcImpl();
	public SignUpServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Sign Up Servlet");
		Customer customer=(Customer) request.getAttribute("cust");
		System.out.println(customer);
		//System.out.println(request.getParameter("msg"));
		daoJdbc.create(customer);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/SignUpSuccessful.jsp");
		rd.forward(request, response);
		
	}

}
