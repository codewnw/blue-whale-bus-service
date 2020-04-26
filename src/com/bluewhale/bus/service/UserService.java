package com.bluewhale.bus.service;

import com.bluewhale.bus.model.User;

public interface UserService {
	void create(User user);

	void read(String username);

	void update(User user);

	void delete(String username);
}
