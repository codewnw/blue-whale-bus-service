package com.bluewhale.bus.servlet;

import java.io.IOException;
import java.util.List;

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
import com.bluewhale.bus.model.Bus;
import com.bluewhale.bus.util.MockDataUtil;

@WebServlet(urlPatterns = { "/buses/*" })
public class BusServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(BusServlet.class);

	private static final long serialVersionUID = 1L;

	public BusServlet() {
		super();
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
			Bus bus = new Bus();
			for (int i = 1; i < 21; i++) {
				bus.getSeats().add(i);
			}
			session.setAttribute("bus", bus);
			response.sendRedirect("../../book-seats.jsp");
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
		} else if (uri.contains("temp")) {
			String[] seatNumbers = request.getParameterValues("seatNo");
			for (int i = 0; i < seatNumbers.length; i++) {
				System.out.println(seatNumbers[i] + " ");
			}
		} else {
			response.sendRedirect("../index.jsp");
		}
	}

}
