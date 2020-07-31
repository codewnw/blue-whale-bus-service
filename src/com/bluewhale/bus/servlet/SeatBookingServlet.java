package com.bluewhale.bus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.service.BookingService;
import com.bluewhale.bus.service.BookingServiceImpl;

@WebServlet("/book-seat")
public class SeatBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookingService bookingService;
	
    public SeatBookingServlet() {
    	bookingService=new BookingServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Seat Booking Servlet");
		Booking booking=(Booking) request.getAttribute("bookSeat");
		booking.setBookingStatus("SUCCESS");
		System.out.println(booking);
		HttpSession session=request.getSession(false);
		String username=(String) session.getAttribute("username");
		booking.setUserId(username);
		boolean isSeatBooked=bookingService.create(booking);
		if(isSeatBooked) {
			request.setAttribute("bookSeat", booking);
			RequestDispatcher rd = request.getRequestDispatcher("BookingDetails.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("bookSeat.jsp");
		
	}

}
