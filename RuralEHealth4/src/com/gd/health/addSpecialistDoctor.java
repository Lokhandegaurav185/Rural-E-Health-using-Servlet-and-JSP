package com.gd.health;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addSpecialistDoctor
 */
public class addSpecialistDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSpecialistDoctor() {
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
			
			PreparedStatement ps = con.prepareStatement("insert into specialistdoctor values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("password"));
			ps.setString(5, request.getParameter("mobile"));
			ps.setString(6, request.getParameter("city"));
			ps.setString(7, request.getParameter("specialization"));
			ps.setString(8, request.getParameter("treate"));
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("success.html");
			}
			else
			{
				response.sendRedirect("fail.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
