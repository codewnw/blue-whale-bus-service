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

import com.bluewhale.bus.dao.DaoJdbcImpl;
import com.bluewhale.bus.model.BookingHistory;
import com.bluewhale.bus.model.Customer;

@WebServlet("/booking-history")
public class BookingHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private com.bluewhale.bus.dao.DaoJdbc daoJdbc=null;
	
    public BookingHistoryServlet() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	System.out.println("Booking History Servlet");
    	daoJdbc=new DaoJdbcImpl();
    	HttpSession session=request.getSession(false);
		Customer customer=(Customer)session.getAttribute("existingCust");
		List<BookingHistory> bookingHistoryList=daoJdbc.findBookingHistoryByCustomer(customer.getcId());
		System.out.println(bookingHistoryList);
		request.setAttribute("bookingHistList", bookingHistoryList);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/HistoryOfBookings.jsp");
		rd.forward(request, response);
	}

}
