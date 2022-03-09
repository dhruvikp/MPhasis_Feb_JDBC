package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection;

	public DBConnection(String dbURL, String userId, String pwd) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		this.connection = DriverManager.getConnection(dbURL, userId, pwd);
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() throws SQLException {
		if (this.connection != null) {
			this.connection.close();
		}
	}

}
