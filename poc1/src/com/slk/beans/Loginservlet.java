package com.slk.beans;

import java.io.IOException;
import com.slk.dao.Login1;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		String uname=req.getParameter("userName");
		String pass=req.getParameter("pass");
		Login1 login=new Login1();
		
	if (login.check(uname, pass)) {
			
		HttpSession session = req.getSession();
		session.setAttribute("name",uname);
			res.sendRedirect("welcome.jsp");}

		else {
			PrintWriter out=res.getWriter();
			out.println("incorrect passworfd");
			RequestDispatcher rd=req.getRequestDispatcher("incorrect.html");
			rd.forward(req, res);
		}

		
	}
}
