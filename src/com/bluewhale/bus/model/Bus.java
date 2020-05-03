package com.bluewhale.bus.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bus {

	@Override
	public String toString() {
		return "Bus [id=" + id + ", type=" + type + ", departureTime=" + departureTime + ", origin=" + origin
				+ ", departureDate=" + departureDate + ", arrivalTime=" + arrivalTime + ", destination=" + destination
				+ ", arrivalDate=" + arrivalDate + ", fare=" + fare + ", travelTime=" + travelTime + ", amenities="
				+ amenities + ", seats=" + seats + "]";
	}

	private String id;

	private String type;

	private String departureTime;

	private String origin;

	private LocalDate departureDate;

	private String arrivalTime;

	private String destination;

	private LocalDate arrivalDate;

	private BigInteger fare;

	private Integer travelTime;

	private List<String> amenities;

	private List<Integer> seats;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public BigInteger getFare() {
		return fare;
	}

	public void setFare(BigInteger fare) {
		this.fare = fare;
	}

	public Integer getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Integer travelTime) {
		this.travelTime = travelTime;
	}

	public List<String> getAmenities() {
		if (this.amenities == null) {
			this.amenities = new ArrayList<>();
		}
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
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
