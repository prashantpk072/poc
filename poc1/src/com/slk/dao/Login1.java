package com.slk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login1 {
	String url = "jdbc:h2:tcp://localhost/~/test";
	String username = "sa";
	static final String JDBC_DRIVER = "org.h2.Driver";

	String password = "";

	public boolean check(String user_name, String pass) {

		try {

			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(url, username, password);
		
			String sql = "select * from login where user_name=?and pass=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user_name);
		st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
