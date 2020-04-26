package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserVerficationDaoImpl implements UserVerficationDao {
	private static final String INSERT_QUERY = "INSERT INTO OTP VALUES (?, ?)";
	private static final String VERIFY_QUERY = "SELECT * FROM OTP WHERE USERNAME = ? AND OTP = ?";
	private static final String DELETE_QUERY = "DELETE FROM OTP WHERE USERNAME  = ?";

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
	public void delete(String username) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {
			pstmt.setString(1, username);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
