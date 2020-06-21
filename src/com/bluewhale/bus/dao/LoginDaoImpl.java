package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bluewhale.bus.model.Login;
import com.bluewhale.bus.model.Password;

public class LoginDaoImpl implements LoginDao {

	private static final String CREATE_TABLE = "CREATE TABLE LOGIN (USERNAME VARCHAR(256) PRIMARY KEY, PASSWORD VARCHAR(256), TYPE VARCHAR(128), STATUS VARCHAR(128))";
	private static final String DROP_TABLE = "DROP TABLE LOGIN";
	private static final String QUERY = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
	private static final String INSERT_QUERY = "INSERT INTO LOGIN VALUES(?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE LOGIN SET STATUS = ? WHERE USERNAME = ?";

	@Override
	public String checkStatus(Login login) {
		String status = null;
		try (Connection conn = DbUtil.getCon(); PreparedStatement pstmt = conn.prepareStatement(QUERY);) {
			pstmt.setString(1, login.getUnsername());
			pstmt.setString(2, login.getPassword().getSecuredPassword());
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
			pstmt.setString(2, login.getPassword().getSecuredPassword());
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
		System.out.println(this.getClass().getSimpleName() + " insertBaseData");
		Login login = new Login();
		login.setUnsername("admin");
		login.setPassword(new Password("admin"));
		login.setType("admin");
		login.setStatus("Verified");
		create(login);
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
