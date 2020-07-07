package com.bluewhale.bus.service;

import javax.management.RuntimeErrorException;

import com.bluewhale.bus.dao.UserVerficationDao;
import com.bluewhale.bus.dao.UserVerficationDaoImpl;

public class UserVerficationServiceImpl implements UserVerficationService {

	private UserVerficationDao userVerficationDao;

	public UserVerficationServiceImpl() {
		userVerficationDao = new UserVerficationDaoImpl();
	}

	@Override
	public String create(String username) {
		return userVerficationDao.create(username);
	}

	@Override
	public boolean verify(String username, String otp) {
		return userVerficationDao.verify(username, otp);
	}

	@Override
	public boolean resetPassword(String username, String password) {
		return userVerficationDao.resetPassword(username, password);
	}

	@Override
	public void delete(String username) {
		userVerficationDao.delete(username);
	}

	@Override
	public boolean forgotPassword(String username) {

		boolean userExists = userVerficationDao.isExistingUser(username);
//		if (!userExists) {
//			throw new RuntimeException("User does not exists");
//		}
		return userExists;
	}

	@Override
	public boolean verifyOldPassword(String username, String oldPassword) {
		return userVerficationDao.verifyOldPassword(username, oldPassword);
	}

	@Override
	public boolean isExistingUser(String username) {
		return userVerficationDao.isExistingUser(username);
	}	

}
