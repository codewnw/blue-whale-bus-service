package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil {

	public static Connection connection;

	public static Connection getCon() throws SQLException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		String url = resourceBundle.getString("url");
		String driver = resourceBundle.getString("driver");
		String username = resourceBundle.getString("username");
		String password = resourceBundle.getString("password");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
