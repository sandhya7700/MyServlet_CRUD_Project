package com.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/grastech","root","admin");
			PreparedStatement ps=con.prepareStatement("insert into logins(iname,fname,lname,ename,aname,cname,pname) values(?,?,?,?,?,?,?)");
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String iname=request.getParameter("iname");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String ename=request.getParameter("ename");
			String aname=request.getParameter("aname");
			String cname=request.getParameter("cname");
			String pname=request.getParameter("pname");
			
			
			ps.setString(1, iname);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, ename);
			ps.setString(5, aname);
			ps.setString(6, cname);
			ps.setString(7, pname);
			
			pw.println("<font size='red'><center><h1>Welcome to "+fname+"</h1></center></font>");

			int rowsaffected =ps.executeUpdate();
			System.out.print("Rows affected"+rowsaffected);
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
