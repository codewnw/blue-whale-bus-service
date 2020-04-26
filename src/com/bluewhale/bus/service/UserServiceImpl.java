package com.bluewhale.bus.service;

import com.bluewhale.bus.dao.UserDao;
import com.bluewhale.bus.dao.UserDaoImpl;
import com.bluewhale.bus.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void create(User user) {
		userDao.create(user);
	}

	@Override
	public void read(String username) {
		userDao.read(username);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(String username) {
		userDao.delete(username);
	}

}
