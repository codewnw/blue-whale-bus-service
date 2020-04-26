package com.bluewhale.Importutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbUtil {

	public static Connection getDbConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/rapid_cart", "rapidcart", "rapidcart");
	}
}