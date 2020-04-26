package com.bluewhale.bus.dao;

public interface UserVerficationDao {
	String create(String username);

	boolean verify(String username, String otp);

	void delete(String username);
}