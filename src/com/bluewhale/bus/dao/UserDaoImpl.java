package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bluewhale.bus.model.User;

public class UserDaoImpl implements UserDao {
	private static final String QUERY = "INSERT INTO USER VALUE (?, ?, ?, ?, ?, ?)";

	@Override
	public void create(User user) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(QUERY)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, null);
			pstmt.setDate(5, null);
			pstmt.setString(6, null);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub

	}
}
