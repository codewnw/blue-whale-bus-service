package com.bluewhale.bus.dao;

import java.util.List;

import com.bluewhale.bus.exception.DAOException;
import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.BookingHistory;
import com.bluewhale.bus.model.Customer;
import com.bluewhale.bus.model.User;

public interface DaoJdbc {

	public void create(User user) throws IllegalArgumentException, DAOException;
	
	public boolean find(String username, String password) throws DAOException;
	
	public boolean bookSeat(Booking booking, int customerId) throws DAOException;
	
	public Customer findCustomer(String username) throws DAOException;
	
	public List<BookingHistory> findBookingHistoryByCustomer(int custId) throws DAOException;
	
}
