package com.bluewhale.bus.dao;

public interface UserVerficationDao extends BaseDao {

	String create(String username);

	boolean verify(String username, String otp);

	void delete(String username);

	boolean isExistingUser(String username);

	boolean resetPassword(String username, String password);

	boolean verifyOldPassword(String username, String oldPassword);

}
