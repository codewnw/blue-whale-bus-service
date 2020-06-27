package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
	private static final String SQL_INSERT_NEW_seat_booking = "INSERT INTO Booking(booking_status, Bus_no, Seat_no, Price,"
			+ " Payment_mode, username, Booking_date, From_Place, To_Place, Travel_Date) VALUES(?, ?, ? ,?, ?,?,?, ?,?,?)";
	
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
	public void create(Booking booking) {
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Booking booking, String username) {
		booking.setBookingCreatedDate(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		Object[] values = { booking.getBookingStatus(), booking.getBusId(), booking.getSeatNo(),
				booking.getBookingPrice(), booking.getPaymentMode(), username, booking.getBookingCreatedDate(),
				booking.getFromPlace(), booking.getToPlace(), booking.getTravelDate() };
		Connection connection;
		try {
			connection = DbUtil.getCon();
			PreparedStatement statement = prepareStatement(connection, SQL_INSERT_NEW_seat_booking, true,
					values);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating booking failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					booking.setbId(generatedKeys.getInt(1));
				} else {
					throw new DAOException("Creating booking failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return true;
	}
	
	private static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys,
			Object... values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		setValues(statement, values);
		return statement;
	}

	public static void setValues(PreparedStatement pstmt, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			pstmt.setObject(i + 1, values[i]);
		}
	}

}
