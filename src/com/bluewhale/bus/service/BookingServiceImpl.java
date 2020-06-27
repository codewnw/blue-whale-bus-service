package com.bluewhale.bus.service;

import com.bluewhale.bus.dao.BookingDao;
import com.bluewhale.bus.dao.BookingDaoImpl;
import com.bluewhale.bus.model.Booking;

public class BookingServiceImpl implements BookingService {

	private BookingDao bookingDao;
	
	public BookingServiceImpl() {
		bookingDao=new BookingDaoImpl();
	}

	public boolean create(Booking booking, String username) {
		return bookingDao.create(booking,username);
	}
}
