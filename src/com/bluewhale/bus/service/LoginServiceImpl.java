package com.bluewhale.bus.service;

import com.bluewhale.bus.dao.LoginDao;
import com.bluewhale.bus.dao.LoginDaoImpl;
import com.bluewhale.bus.model.Login;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public void create(Login login) {
		loginDao.create(login);
	}

	@Override
	public void read(String username) {
		loginDao.read(username);
	}

	@Override
	public void update(Login login) {
		loginDao.update(login);
	}

	@Override
	public void delete(String username) {
		loginDao.delete(username);
	}

	@Override
	public String checkStatus(String unsername, String password) {
		return loginDao.checkStatus(unsername, password);
	}

}
