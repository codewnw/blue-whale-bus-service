package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.bluewhale.bus.exception.DAOException;
import com.bluewhale.bus.model.Booking;

public class BookingDaoImpl implements BookingDao {

	private static final String CREATE_TABLE = "Create Table Booking (\r\n" + 
			"booking_id int(11) auto_increment,\r\n" + 
			"booking_status varchar(256) ,\r\n" + 
			"Bus_no varchar(256) ,\r\n" + 
			"Seat_no varchar(256),\r\n" + 
			"Price varchar(256),\r\n" + 
			"Payment_mode varchar(256),\r\n" + 
			"username varchar(256),\r\n" + 
			"Booking_date date,\r\n" + 
			"From_Place varchar(256),\r\n" + 
			"To_Place varchar(256),\r\n" + 
			"Travel_Date date,\r\n" + 
			"PRIMARY KEY (booking_id))";
	private static final String DROP_TABLE = "DROP TABLE Booking";
	private static final String INSERT_QUERY = "INSERT INTO Booking VALUES (?, ?, ?,?, ?,?,?, ?,?,?,?)";
	
	@Override
	public void createTable() {

		System.out.println(this.getClass().getSimpleName() + " createTable");
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(CREATE_TABLE);) {
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertBaseData() {

		System.out.println(this.getClass().getSimpleName() + " insertBaseData");
		Booking	booking = new Booking();
		booking.setbId(1);
		booking.setBookingStatus("Success");
		booking.setBusId("24A");
		booking.setSeatNo("5,6");
		booking.setBookingPrice((long) 550.50);
		booking.setFromPlace("Bangalore");
		booking.setToPlace("Mysore");
		booking.setPaymentMode("Credit Card");
		booking.setUserId("admin");
		booking.setTravelDate("2020-05-10");
		create(booking);
	}

	@Override
	public void dropTable() {
		System.out.println(this.getClass().getSimpleName() + " dropTable");
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(DROP_TABLE);) {
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Booking booking) {
		boolean isBookingCreated=false;
		booking.setBookingCreatedDate(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		booking.setBookingStatus("Confirmed");
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY);) {
			pstmt.setLong(1, booking.getbId());
			pstmt.setString(2, booking.getBookingStatus());
			pstmt.setString(3, booking.getBusId());
			pstmt.setString(4, booking.getSeatNo());
			pstmt.setLong(5, booking.getBookingPrice());
			pstmt.setString(6, booking.getPaymentMode());
			pstmt.setString(7, booking.getUserId());
			pstmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setString(9, booking.getFromPlace());
			pstmt.setString(10, booking.getToPlace());
			pstmt.setDate(11, java.sql.Date.valueOf(booking.getTravelDate()));
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 0) {
				System.out.println("Creating booking failed, no rows affected.");
				booking.setBookingStatus("Not Confirmed");
				//Need to update the booking table with the status
			}else {
				isBookingCreated= true;
			}
			return isBookingCreated;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isBookingCreated;
	}
}
