package com.bluewhale.bus.model;

public class Booking {

	private long bId;
	private String userId;
	private String busId;
	private String seatNo;
	private String fromPlace;
	private String toPlace;
	private String travelDate;
	private String bookingStatus;
	private String paymentMode;
	private long bookingPrice;
	private String bookingCreatedDate;
	
	@Override
	public String toString() {
		return "Booking [bId=" + bId + ", userId=" + userId + ", busId=" + busId + ", seatNo=" + seatNo + ", fromPlace="
				+ fromPlace + ", toPlace=" + toPlace + ", travelDate=" + travelDate + ", bookingStatus=" + bookingStatus
				+ ", paymentMode=" + paymentMode + ", bookingPrice=" + bookingPrice + ", bookingCreatedDate="
				+ bookingCreatedDate + "]";
	}
	
	public long getbId() {
		return bId;
	}
	public void setbId(long bId) {
		this.bId = bId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public long getBookingPrice() {
		return bookingPrice;
	}
	public void setBookingPrice(long bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	public String getBookingCreatedDate() {
		return bookingCreatedDate;
	}
	public void setBookingCreatedDate(String bookingCreatedDate) {
		this.bookingCreatedDate = bookingCreatedDate;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}
