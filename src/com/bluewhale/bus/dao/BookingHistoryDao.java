package com.bluewhale.bus.dao;

import java.util.List;

import com.bluewhale.bus.model.BookingHistory;

public interface BookingHistoryDao {

	public List<BookingHistory> findBookingHistoryByCustomer(String username);
}
