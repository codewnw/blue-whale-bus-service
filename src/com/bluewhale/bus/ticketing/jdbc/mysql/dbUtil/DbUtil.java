package com.bus.ticketing.jdbc.mysql.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bus.ticketing.dao.exception.DAOConfigurationException;
import com.bus.ticketing.dao.properties.DAOProperties;

public class DbUtil {

	private static final String PROPERTY_URL = "jdbc.url";
	private static final String PROPERTY_DRIVER = "jdbc.driver";
	private static final String PROPERTY_USERNAME = "jdbc.username";
	private static final String PROPERTY_PASSWORD = "jdbc.password";

	public static Connection getDbConnection() throws SQLException {

		DAOProperties properties = new DAOProperties();
		String url = properties.getProperty(PROPERTY_URL, true);
		String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
		String password = properties.getProperty(PROPERTY_PASSWORD, false);
		String username = properties.getProperty(PROPERTY_USERNAME, password != null);

		if (driverClassName != null) {
			System.out.println("Driver Class Name : " + driverClassName);
			try {
				Class.forName(driverClassName);
				return DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				throw new DAOConfigurationException("Driver class '" + driverClassName + "' is missing in classpath.",
						e);
			}
		}
		return null;
	}

	public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys,
			Object... values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		setValues(statement, values);
		return statement;
	}
	
	public static void setValues(PreparedStatement statement, Object... values)
	        throws SQLException
	    {
	        for (int i = 0; i < values.length; i++) {
	            statement.setObject(i + 1, values[i]);
	        }
	    }
}
