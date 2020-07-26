package com.bluewhale.bus.dao;

import com.bluewhale.bus.model.Booking;
import com.bluewhale.bus.model.User;

public interface BookingDao extends BaseDao {

	boolean create(Booking booking);
}
