package com.gd.health;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCaseAV
 */
public class AddCaseAV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCaseAV() {
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
			
			PreparedStatement ps1 = con.prepareStatement("insert into case_tbl values(?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, request.getParameter("name"));
			ps1.setString(3, request.getParameter("age"));
			ps1.setString(4, request.getParameter("address"));
			ps1.setString(5, request.getParameter("gender"));
			ps1.setString(6, request.getParameter("mobile"));
			ps1.setString(7, request.getParameter("symp1"));
			ps1.setString(8, request.getParameter("symp2"));
			ps1.setString(9, request.getParameter("symp3"));
			ps1.setString(10, request.getParameter("disesase"));
			ps1.setString(11, request.getParameter("doctor"));
			
			int i = ps1.executeUpdate();
			
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
