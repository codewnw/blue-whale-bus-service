package com.bluewhale.bus.model;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Long phoneNo;
	private String dob;
	private String email;
	private String address;
	private String gender;
	private String country;
	
//	private List<Booking> userBookings;
	public Customer() {}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", dob=" + dob + ", email=" + email + ", address="
				+ address + ", gender=" + gender + ", country=" + country + "]";
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getcId() {
		return cId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public List<Booking> getUserBookings() {
		return userBookings;
	}

	public void setUserBookings(List<Booking> userBookings) {
		this.userBookings = userBookings;
	}
	*/
}
