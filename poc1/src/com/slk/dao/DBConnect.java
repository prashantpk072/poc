package com.slk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.slk.beans.Billdetails;
//import com.slk.beans.Category;
//import com.slk.beans.Items;
import com.slk.beans.Login;
//import com.slk.beans.OrderDetails;
//import com.slk.beans.OrderMaster;
//import com.slk.beans.OrderMaster.OrderStatus;

public class DBConnect {
	private static Connection connection = null;
	private static String DRIVER_NAME = "org.h2.Driver";
	// private static String DATABASE_NAME= "hotel_order";
private static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
private static String USER_NAME = "sa";
private static String PASSWORD = "";
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME,
					PASSWORD);
			return con;
		//	return con;
		} catch (ClassNotFoundException cne) {
			System.out.println(cne);
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
		return con;
	}

	public void closeConnection() {
		try {

			if (connection != null)
				connection.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
	}

	public boolean checkLogin(Login login) {
		String SQL = "select user_name,pass from login where user_name='" + login.getUserName() + "' and pass='"
				+ login.getPassword() + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;
				else
					result = Boolean.FALSE;
				closeConnection();
			} else {
				System.out.println("Connection is null in checkLogin");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in checkLogin - " + sqle);
		}
		return result;
	}

	public boolean isAlreadyExists(String name) {
		String SQL = "select name from category where name='" + name + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in isAlreadyExists");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in isAlreadyExists - " + sqle);
		}
		return result;
	}
}