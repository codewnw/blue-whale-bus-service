package com.bluewhale.bus.model;

import java.util.ArrayList;
import java.util.List;

public class Bus {

	private long busId;

	private List<Integer> seats;

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public List<Integer> getSeats() {
		if (this.seats == null) {
			this.seats = new ArrayList<>();
		}
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

}
