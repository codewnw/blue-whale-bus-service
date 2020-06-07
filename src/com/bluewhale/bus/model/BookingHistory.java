package com.bluewhale.bus.model;

public class BookingHistory {

	private int bookingId;
	private String travelDate;
	private String busId;
	private String seatNo;
	private String bookingStatus;	
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String string) {
		this.seatNo = string;
	}

	@Override
	public String toString() {
		return "BookingHistory [bookingId=" + bookingId + ", travelDate=" + travelDate + ", busId=" + busId
				+ ", seatNo=" + seatNo + ", bookingStatus=" + bookingStatus + "]";
	}
}
