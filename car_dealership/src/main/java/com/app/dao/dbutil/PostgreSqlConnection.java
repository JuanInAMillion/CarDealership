package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnection {
private static Connection connection;
	
	private PostgreSqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");	
		String url="jdbc:postgresql://jan25instance.cxiq0hmzrebq.us-east-2.rds.amazonaws.com:5432/postgres";
		String username="postgres";
		String password="password";
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
}
