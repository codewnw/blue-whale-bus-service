package com.bluewhale.bus.service;

import com.bluewhale.bus.model.Booking;

public interface BookingService {

	public boolean create(Booking booking, String username);
}
