package com.project;

import jakarta.servlet.ServletException;
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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/grastech","root","admin");
			PreparedStatement ps=con.prepareStatement("update logins set aname=? , cname=? , ename=? where iname=?");
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String iname=request.getParameter("iname");
			//String fname=request.getParameter("fname");
			//String lname=request.getParameter("lname");
			String ename=request.getParameter("ename");
			String aname=request.getParameter("aname");
			String cname=request.getParameter("cname");
			//String pname=request.getParameter("pname");
			
			
			ps.setString(1, aname);
			ps.setString(2, cname);
			ps.setString(3, ename);
			ps.setString(4, iname);
			
			pw.println("<font size='red'><center><h1>Updated your data</h1></center></font>");

			int rowsaffected =ps.executeUpdate();
			System.out.print("Rows updated"+rowsaffected);
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
