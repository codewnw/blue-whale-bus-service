package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluewhale.bus.dao.DaoJdbc;
import com.bluewhale.bus.dao.DaoJdbcImpl;
import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.Customer;

@WebServlet("/book-seat")
public class SeatBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoJdbc daoJdbc=null; 
	
    public SeatBookingServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoJdbc = new DaoJdbcImpl();
		System.out.println("Seat Booking Servlet");
		Booking booking=(Booking) request.getAttribute("bookSeat");
		booking.setBookingStatus("SUCCESS");
		System.out.println(booking);
		HttpSession session=request.getSession(false);
		Customer customer=(Customer)session.getAttribute("existingCust");
		boolean isSeatBooked=daoJdbc.bookSeat(booking, customer.getcId());
		if(isSeatBooked) {
			request.setAttribute("bookSeat", booking);
			RequestDispatcher rd = request.getRequestDispatcher("BookingDetails.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("bookSeat.jsp");
		
	}

}
