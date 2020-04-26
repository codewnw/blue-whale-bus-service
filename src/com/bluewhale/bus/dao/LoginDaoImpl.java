package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bluewhale.bus.model.Login;

public class LoginDaoImpl implements LoginDao {

	private static final String QUERY = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
	private static final String INSERT_QUERY = "INSERT INTO LOGIN VALUES(?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE LOGIN SET STATUS = ? WHERE USERNAME = ?";

	@Override
	public String checkStatus(String unsername, String password) {
		String status = null;
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(QUERY);) {
			pstmt.setString(1, unsername);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				status = rs.getString("STATUS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void create(Login login) {
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY);) {
			pstmt.setString(1, login.getUnsername());
			pstmt.setString(2, login.getPassword());
			pstmt.setString(3, login.getType());
			pstmt.setString(4, login.getStatus());
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
	public void update(Login login) {
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);) {
			pstmt.setString(1, login.getStatus());
			pstmt.setString(2, login.getUnsername());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub

	}

}
