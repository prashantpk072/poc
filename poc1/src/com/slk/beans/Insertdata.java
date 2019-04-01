package com.slk.beans;

import java.io.IOException;
import com.slk.dao.Login1;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.slk.dao.Registerservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Insertdata extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		String user_name=req.getParameter("userName");
		String pass=req.getParameter("pass");
		Login1 login=new Login1();
		
		
        
			try {
				Connection con = Registerservlet.initializeDatabase();
				PreparedStatement st = con 
				           .prepareStatement("insert into login values(?, ?)");
				st.setString(1, user_name);
				st.setString(2, pass);
				st.executeUpdate(); 
				st.close(); 
				con.close(); 
				PrintWriter out = res.getWriter(); 
				out.println("<html><body><b>Successfully Inserted"
				            + "</b></body></html>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
       
	}}

	