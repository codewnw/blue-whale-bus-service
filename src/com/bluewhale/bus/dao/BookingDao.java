package com.bluewhale.bus.dao;

import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.User;

public interface BookingDao extends BaseDao {

	void create(Booking booking);
	
	boolean create(Booking booking, String username);
}
