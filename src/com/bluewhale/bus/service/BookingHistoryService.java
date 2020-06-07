package com.bluewhale.bus.service;

import java.util.List;

import com.bluewhale.bus.model.BookingHistory;

public interface BookingHistoryService {

	public List<BookingHistory> findBookingHistoryByCustomer(String username);
}
