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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Show
 */
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			pw.println("<html><body>");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/grastech","root","admin");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from logins");
			
           pw.println("<table border=2 width=100% height=10%>");
           pw.println("<tr><th>User Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Address</th><th>Contact</th><th>Password</th></tr>");
                while (rs.next()) {
                	{
pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
                	}  
                //pw.println("</table>");
		} 
                pw.println("</table></body></html>");
                }
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}  
	} 