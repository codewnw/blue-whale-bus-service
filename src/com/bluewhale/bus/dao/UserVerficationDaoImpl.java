package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserVerficationDaoImpl implements UserVerficationDao {
	private static final String CREATE_TABLE = "CREATE TABLE OTP (username VARCHAR(256) PRIMARY KEY, OTP VARCHAR(10))";
	private static final String DROP_TABLE = "DROP TABLE OTP";
	private static final String INSERT_QUERY = "INSERT INTO OTP VALUES (?, ?)";
	private static final String VERIFY_QUERY = "SELECT * FROM OTP WHERE USERNAME = ? AND OTP = ?";
	private static final String DELETE_QUERY = "DELETE FROM OTP WHERE USERNAME  = ?";
	private static final String EXISTS_QUERY = "SELECT * FROM USER WHERE USERNAME  = ?";
	private static final String PASSWDUPDATE_QUERY = "UPDATE LOGIN SET PASSWORD = ? WHERE USERNAME = ?";

	@Override
	public String create(String username) {
		String otp = null;
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {
			pstmt.setString(1, username);
			otp = (int) (Math.random() * 10000) + "";
			pstmt.setString(2, otp);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;
	}

	@Override
	public boolean verify(String username, String otp) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(VERIFY_QUERY)) {
			pstmt.setString(1, username);
			pstmt.setString(2, otp);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean resetPassword(String username, String password) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(PASSWDUPDATE_QUERY)) {
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			int rs = pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isExistingUser(String username) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(EXISTS_QUERY)) {
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(String username) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {
			pstmt.setString(1, username);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
