package com.bluewhale.bus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtil implements BaseDao {

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

	@Override
	public void createTable() {
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.createTable();

		UserDao userDao = new UserDaoImpl();
		userDao.createTable();

		UserVerficationDao userVerficationDao = new UserVerficationDaoImpl();
		userVerficationDao.createTable();
	}

	@Override
	public void insertBaseData() {
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.insertBaseData();

		UserDao userDao = new UserDaoImpl();
		userDao.insertBaseData();

		UserVerficationDao userVerficationDao = new UserVerficationDaoImpl();
		userVerficationDao.insertBaseData();
	}

	@Override
	public void dropTable() {
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.dropTable();

		UserDao userDao = new UserDaoImpl();
		userDao.dropTable();

		UserVerficationDao userVerficationDao = new UserVerficationDaoImpl();
		userVerficationDao.dropTable();
	}

//	To be deleted
	public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys,
			Object... values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		setValues(statement, values);
		return statement;
	}

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

}
