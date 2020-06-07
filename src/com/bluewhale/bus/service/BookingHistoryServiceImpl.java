package com.bluewhale.bus.service;

import java.util.List;

import com.bluewhale.bus.dao.BookingHistoryDao;
import com.bluewhale.bus.dao.BookingHistoryDaoImpl;
import com.bluewhale.bus.model.BookingHistory;

public class BookingHistoryServiceImpl implements BookingHistoryService {

	private BookingHistoryDao bookingHistoryDao;
	
	public BookingHistoryServiceImpl() {
		bookingHistoryDao=new BookingHistoryDaoImpl();
	}
	
	@Override
	public List<BookingHistory> findBookingHistoryByCustomer(String username){
		System.out.println("In Service "+username);
		return bookingHistoryDao.findBookingHistoryByCustomer(username);
	}
}
