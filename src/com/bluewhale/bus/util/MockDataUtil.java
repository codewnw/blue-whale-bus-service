package com.bluewhale.bus.util;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bluewhale.bus.model.Bus;

public class MockDataUtil {

	public static List<Bus> getBuses() {
		List<Bus> buses = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Bus bus = new Bus();
			bus.setId("BUS_" + i);
			bus.setType("Volvo");
			bus.setDepartureTime("10:30 AM");
			bus.setOrigin("Origin " + i);
			bus.setDepartureDate(LocalDate.of(2020, 1 + i, 3 + i));
			bus.setArrivalTime("11:20 PM");
			bus.setDestination("Destination " + i);
			bus.setArrivalDate(LocalDate.of(2020, 2 + i, 4 + i));
			bus.setFare(BigInteger.TEN);
			bus.setTravelTime(Integer.valueOf("12"));
			bus.setAmenities(Arrays.asList("AC", "Charger", "Water Bottle", "WiFi", "Blanket"));
			for (int j = 1; j < 21; j++) {
				bus.getSeats().add(j);
			}
			buses.add(bus);
		}
		return buses;
	}
}
