package com.slk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registerservlet {
	static String url = "jdbc:h2:tcp://localhost/~/test";
	static String username = "sa";
	static final String JDBC_DRIVER = "org.h2.Driver";

	static String password = "";

	public static Connection initializeDatabase() throws ClassNotFoundException, SQLException

	{

		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(url, username, password);

		return con;
	}
}