package com.bluewhale.bus.service;

public interface UserVerficationService {
	String create(String username);

	boolean verify(String username, String otp);

	void delete(String username);
}
