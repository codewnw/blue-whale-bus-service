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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluewhale.Importutils.CsvReader;
import com.bluewhale.Importutils.DbWriter;
import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.Bus;
import com.bluewhale.bus.service.BookingService;
import com.bluewhale.bus.service.BookingServiceImpl;
import com.bluewhale.bus.service.MailService;
import com.bluewhale.bus.util.MockDataUtil;

@WebServlet(urlPatterns = { "/buses/*" })
public class BusServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(BusServlet.class);

	private static final long serialVersionUID = 1L;
	
	private BookingService bookingService;
	
	private MailService mailService;

	public BusServlet() {
		super();
		bookingService=new BookingServiceImpl();
		mailService = new MailService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("Inside Class :" + this.getClass().getSimpleName());

		String uri = request.getRequestURI();

		System.out.println(uri);
		if (uri.contains("upload-schedule-form")) {
			response.sendRedirect("../upload-schedule-form.jsp");
		} else if (uri.contains("info")) {
			HttpSession session = request.getSession(false);
			String username=(String)session.getAttribute("username");
			if(username==null) {
				System.out.println("Not logged in..");
				String loginErrMessage="Not logged in. Please login to continue !";
				String baseUri=request.getContextPath();
				System.out.println(baseUri);
				response.sendRedirect(baseUri+"/login.jsp?loginErrMessage="+loginErrMessage);
			}
			else {
				System.out.println("Logged in");
				response.sendRedirect("../../book-seats.jsp");
			}
		} else if (uri.contains("all")) {
			List<Bus> buses = MockDataUtil.getBuses();
			HttpSession session = request.getSession(false);
			session.setAttribute("buses", buses);
			response.sendRedirect("../buses.jsp");
		} else {
			response.sendRedirect("../index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("Inside Class :" + this.getClass().getSimpleName());

		String uri = request.getRequestURI();

		if (uri.contains("upload-schedule")) {
			String path = request.getParameter("path");
			System.out.println(path);
			CsvReader csvReader = new CsvReader();
			List<String[]> fileData = csvReader.readData(path);

			DbWriter.writeToDb(fileData);

			response.sendRedirect("../index.jsp");
		} else if (uri.contains("bookSeats")) {
			System.out.println("Booking selected seats..");
			String[] seatNumbers = request.getParameterValues("seatNo");
			HttpSession session = request.getSession(false);
			Bus sBus=(Bus)session.getAttribute("bus");
			String username=(String) session.getAttribute("username");
			System.out.println("sBus : "+sBus);
			StringBuilder seats=null;
			String bookingStatus="Not Confirmed";
			for (int i = 0; i < seatNumbers.length; i++) {
				System.out.print(seatNumbers[i] + " ");
				if(seats==null) {
					seats=new StringBuilder(seatNumbers[i]);
				}
				else {
					seats.append(",").append(seatNumbers[i]);
				}
			}
			Booking newBooking= new Booking();
			newBooking.setbId((long) (Math.random()*100000));
			newBooking.setUserId(username);
			newBooking.setBusId(sBus.getId());
			newBooking.setSeatNo(seats.toString());
			newBooking.setFromPlace(sBus.getOrigin());
			newBooking.setToPlace(sBus.getDestination());
			newBooking.setTravelDate(sBus.getDepartureDate().toString());
			newBooking.setBookingStatus(bookingStatus);
			newBooking.setPaymentMode("Default");
			newBooking.setBookingPrice(sBus.getFare().longValue());
			boolean isSeatBooked=bookingService.create(newBooking);
			logger.debug("isSeatBooked="+isSeatBooked);
			logger.debug("Booking="+newBooking);
			request.removeAttribute("bus");
			if(isSeatBooked) {
				request.setAttribute("emailmsg", "You will receive an email with the Ticket details.");
				request.setAttribute("bookSeat", newBooking);
				request.setAttribute("bookingmsg", "Your Booking is Successful");
				request.setAttribute("bookingId", newBooking.getbId());
				mailService.sendTicket(username, newBooking);
				RequestDispatcher rd = request.getRequestDispatcher("../bookingDetails.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("../index.jsp");
			}
		} else {
			response.sendRedirect("../index.jsp");
		}
	}

}
