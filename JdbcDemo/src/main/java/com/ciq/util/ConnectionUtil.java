package com.ciq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciq", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement ,Connection connection) {

		try {
			if (statement != null) {
				statement.close();
			}
			
			close(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void close(ResultSet resultSet ,Statement statement ,Connection connection) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
			close(statement, connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
