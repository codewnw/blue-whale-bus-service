package com.bluewhale.bus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluewhale.bus.model.BookingHistory;
import com.bluewhale.bus.model.Customer;
import com.bluewhale.bus.service.BookingHistoryService;
import com.bluewhale.bus.service.BookingHistoryServiceImpl;

@WebServlet("/booking-history")
public class BookingHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookingHistoryService bookingHistoryService;
	
    public BookingHistoryServlet() {
    	bookingHistoryService=new BookingHistoryServiceImpl();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	System.out.println("Booking History Servlet");
    	HttpSession session=request.getSession(false);
		String username=(String) session.getAttribute("username");
		List<BookingHistory> bookingHistoryList=bookingHistoryService.findBookingHistoryByCustomer(username);
		System.out.println("***"+bookingHistoryList);
		request.setAttribute("bookingHistList", bookingHistoryList);
		RequestDispatcher rd = request.getRequestDispatcher("historyOfBookings.jsp");
		rd.forward(request, response);
	}

}
