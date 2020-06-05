package com.bluewhale.bus.service;

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

		boolean userExists = userVerficationDao.isUserAlreadyCreated(username);
		if (!userExists) {
			return false;
		}
		new MailService().send(username);
		System.out.println("OTP Sent to email");
		return true;

	}

}
