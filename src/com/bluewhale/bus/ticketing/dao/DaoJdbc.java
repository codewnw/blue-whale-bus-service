package com.bus.ticketing.dao;

import java.util.List;

import com.bus.ticketing.dao.exception.DAOException;
import com.bus.ticketing.dao.model.BookingHistory;
import com.bus.ticketing.model.Booking;
import com.bus.ticketing.model.Customer;

public interface DaoJdbc {

	public void create(Customer customer) throws IllegalArgumentException, DAOException;
	
	public boolean find(String username, String password) throws DAOException;
	
	public boolean bookSeat(Booking booking, int customerId) throws DAOException;
	
	public Customer findCustomer(String username) throws DAOException;
	
	public List<BookingHistory> findBookingHistoryByCustomer(int custId) throws DAOException;
	
}
