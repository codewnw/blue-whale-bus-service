package com.bluewhale.bus.dao;

import com.bluewhale.bus.model.Login;

public interface LoginDao extends BaseDao {

	void create(Login login);

	void read(String username);

	void update(Login login);

	void delete(String username);

	String checkStatus(Login login);
}
