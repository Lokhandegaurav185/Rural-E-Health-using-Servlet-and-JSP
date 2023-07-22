package com.gd.health;
import java.sql.*;
import com.gd.health.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperationOnCase
 */
public class OperationOnCase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationOnCase() {
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
		
		String[] disease=new String[] {"cancer", "corona", "anaemia","appendicitis","bird flu","appendicitis","diabetes","eye cancer","flu","malaria","norovirus"};
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps = con.prepareStatement("update case_tbl set case_tbl.disease and case_tbl.asigndoctor from case_tbl t1,diseases t2 where t1.id=t2.id");
			int i = ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
