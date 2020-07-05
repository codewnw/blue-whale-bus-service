package com.bluewhale.bus.service;

public interface UserVerficationService {
	String create(String username);

	boolean verify(String username, String otp);

	void delete(String username);

	boolean forgotPassword(String username);

	boolean resetPassword(String username, String password);

	boolean verifyOldPassword(String username, String oldPassword);

	boolean isExistingUser(String username);

}
