package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluewhale.Importutils.MyDbUtil;
import com.bluewhale.bus.exception.DAOException;
import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.BookingHistory;
import com.bluewhale.bus.model.Customer;
import com.bluewhale.bus.model.User;

public class DaoJdbcImpl implements DaoJdbc {

	private static final String SQL_INSERT_NEW_customer = "INSERT INTO Customer(username, password, first_name, last_name, "
			+ "phone, birth_date, email_id, address, gender, country) VALUES(?, ?, ? ,?, ?,?,?, ?,?,?)";

	private static final String SQL_Find_by_UserName_Password = "SELECT password FROM customer where username=?";

	private static final String SQL_INSERT_NEW_seat_booking = "INSERT INTO Booking(booking_status, Bus_no, Seat_no, Price,"
			+ " Payment_mode, customer_id, Booking_date, From_Place, To_Place, Travel_Date) VALUES(?, ?, ? ,?, ?,?,?, ?,?,?)";

	private static final String SQL_Find_Customer = "SELECT * FROM customer where username=?";

	private static final String SQL_Booking_History_By_CustomerId = "Select booking_id, booking_status, Bus_no, Seat_no, Travel_Date from Booking where customer_id=?";

	public DaoJdbcImpl() {
	}

	@Override
	public void create(User user) throws IllegalArgumentException, DAOException {
		if (user.getUsername() != null) {
			throw new IllegalArgumentException("customer is already created, the customer ID is not null.");
		}
		Object[] values = { user.getUsername(), user.getFirstName(), user.getLastName() };

		Connection connection;
		try {
			connection = DbUtil.getCon();
			PreparedStatement statement = DbUtil.prepareStatement(connection, SQL_INSERT_NEW_customer, true, values);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setUsername("");
				} else {
					throw new DAOException("Creating user failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public boolean find(String username, String password) throws DAOException {
		boolean userExist = false;
		String passwordFromDB = null;
		Object[] values = { username };
		try (Connection connection = DbUtil.getCon();
				PreparedStatement statement = DbUtil.prepareStatement(connection, SQL_Find_by_UserName_Password, false,
						values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				passwordFromDB = resultSet.getString(1);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		if (passwordFromDB.isEmpty()) {
			System.out.println("No password retrieved for the user");
		} else if (password.equals(passwordFromDB)) {
			userExist = true;
		}
		return userExist;
	}

	@Override
	public boolean bookSeat(Booking booking, int customerId) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		booking.setBookingCreatedDate(date);
		Object[] values = { booking.getBookingStatus(), booking.getBusId(), booking.getSeatNo(),
				booking.getBookingPrice(), booking.getPaymentMode(), customerId, booking.getBookingCreatedDate(),
				booking.getFromPlace(), booking.getToPlace(), booking.getTravelDate() };
		Connection connection;
		try {
			connection = DbUtil.getCon();
			PreparedStatement statement = DbUtil.prepareStatement(connection, SQL_INSERT_NEW_seat_booking, true,
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

	@Override
	public Customer findCustomer(String username) throws DAOException {
		Customer customer = null;
		Object[] values = { username };
		try (Connection connection = DbUtil.getCon();
				PreparedStatement statement = DbUtil.prepareStatement(connection, SQL_Find_Customer, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				customer = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return customer;
	}

	private static Customer map(ResultSet resultSet) throws SQLException {
		Customer customer = new Customer();
		customer.setcId(resultSet.getInt("customer_id"));
		customer.setEmail(resultSet.getString("email_id"));
		customer.setFirstName(resultSet.getString("first_name"));
		customer.setLastName(resultSet.getString("last_name"));
		customer.setDob(resultSet.getString("birth_date"));
		customer.setAddress(resultSet.getString("address"));
		customer.setUserName(resultSet.getString("username"));
		customer.setPhoneNo(resultSet.getLong("phone"));
		customer.setGender(resultSet.getString("gender"));
		customer.setCountry(resultSet.getString("country"));
		return customer;
	}

	@Override
	public List<BookingHistory> findBookingHistoryByCustomer(int custId) {
		List<BookingHistory> bookingHistoryList = null;
		BookingHistory bookingHistory = null;
		Object[] values = { custId };
		try (Connection connection = DbUtil.getCon();
				PreparedStatement statement = DbUtil.prepareStatement(connection, SQL_Booking_History_By_CustomerId,
						false, values);
				ResultSet resultSet = statement.executeQuery();) {
			bookingHistoryList = new ArrayList<>();
			if (resultSet.next()) {
				bookingHistory = mapBookingHistory(resultSet);
				bookingHistoryList.add(bookingHistory);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return bookingHistoryList;
	}

	private BookingHistory mapBookingHistory(ResultSet resultSet) throws SQLException {
		BookingHistory bookingHistory = new BookingHistory();
		bookingHistory.setBookingId(resultSet.getInt("booking_id"));
		bookingHistory.setBusId(resultSet.getString("Bus_no"));
		bookingHistory.setSeatNo(resultSet.getInt("Seat_no"));
		bookingHistory.setTravelDate(resultSet.getString("Travel_Date"));
		bookingHistory.setBookingStatus(resultSet.getString("booking_status"));
		return bookingHistory;
	}
}
