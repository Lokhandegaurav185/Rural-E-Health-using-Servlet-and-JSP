package com.gd.health;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aarogyaVibhagLogin
 */
public class aarogyaVibhagLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aarogyaVibhagLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			
	
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps = con.prepareStatement("select * from aarogyavibhag where email=? and password=?");
			
			ps.setString(1, request.getParameter("email"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				response.sendRedirect("index.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
