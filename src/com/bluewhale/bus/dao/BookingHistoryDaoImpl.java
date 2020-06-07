package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bluewhale.bus.exception.DAOException;
import com.bluewhale.bus.model.BookingHistory;

public class BookingHistoryDaoImpl implements BookingHistoryDao {

	private static final String SQL_Booking_History_By_CustomerId = "Select * from Booking where username=?";

	@Override
	public List<BookingHistory> findBookingHistoryByCustomer(String username) {
		System.out.println(username);
		List<BookingHistory> bookingHistoryList = new ArrayList<>();
		BookingHistory bookingHistory = null;
		Object[] values = { username };
		try (Connection connection = DbUtil.getCon();
				PreparedStatement statement = prepareStatement(connection, SQL_Booking_History_By_CustomerId, false,
						values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				bookingHistory = mapBookingHistory(resultSet);
				bookingHistoryList.add(bookingHistory);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return bookingHistoryList;
	}

	private static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys,
			Object... values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		setValues(statement, values);
		return statement;
	}

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	private BookingHistory mapBookingHistory(ResultSet resultSet) throws SQLException {
		BookingHistory bookingHistory = new BookingHistory();
		bookingHistory.setBookingId(resultSet.getInt("booking_id"));
		bookingHistory.setBusId(resultSet.getString("Bus_no"));
		bookingHistory.setSeatNo(resultSet.getString("Seat_no"));
		bookingHistory.setTravelDate(resultSet.getString("Travel_Date"));
		bookingHistory.setBookingStatus(resultSet.getString("booking_status"));
		return bookingHistory;
	}
}
