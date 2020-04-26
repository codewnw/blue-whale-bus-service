package com.bluewhale.bus.dao;

import com.bluewhale.bus.model.User;

public interface UserDao {
	void create(User user);

	void read(String username);

	void update(User user);

	void delete(String username);
}
