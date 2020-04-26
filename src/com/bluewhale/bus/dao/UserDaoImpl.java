package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bluewhale.bus.model.User;

public class UserDaoImpl implements UserDao {

	private static final String CREATE_TABLE = "CREATE TABLE user (username VARCHAR(256) PRIMARY KEY, first_name VARCHAR(256) NOT NULL, last_name VARCHAR(256) NOT NULL, phone VARCHAR(50), dob DATE, gender VARCHAR(10))";
	private static final String DROP_TABLE = "DROP TABLE USER";
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

	@Override
	public void createTable() {
		System.out.println(this.getClass().getSimpleName() + " createTable");
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(CREATE_TABLE);) {
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertBaseData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropTable() {
		System.out.println(this.getClass().getSimpleName() + " dropTable");
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(DROP_TABLE);) {
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
