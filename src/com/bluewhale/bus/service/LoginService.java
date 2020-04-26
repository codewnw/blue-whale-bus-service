package com.bluewhale.bus.service;

import com.bluewhale.bus.model.Login;

public interface LoginService {
	void create(Login login);

	void read(String username);

	void update(Login login);

	void delete(String username);

	String checkStatus(String unsername, String password);
}
