package com.bluewhale.bus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluewhale.Importutils.CsvReader;
import com.bluewhale.Importutils.DbWriter;

@WebServlet(urlPatterns = { "/buses/*" })
public class BusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BusServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("upload-schedule-form")) {
			response.sendRedirect("../upload-schedule-form.jsp");
		} else {
			response.sendRedirect("../index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("upload-schedule")) {
			String path = request.getParameter("path");
			System.out.println(path);
			CsvReader csvReader = new CsvReader();
			List<String[]> fileData = csvReader.readData(path);

			DbWriter.writeToDb(fileData);

			response.sendRedirect("../index.jsp");
		} else {
			response.sendRedirect("../index.jsp");
		}
	}

}
