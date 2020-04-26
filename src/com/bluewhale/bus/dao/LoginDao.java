package com.bluewhale.bus.dao;

import com.bluewhale.bus.model.Login;

public interface LoginDao {

	void create(Login login);

	void read(String username);

	void update(Login login);

	void delete(String username);

	String checkStatus(String unsername, String password);
}
