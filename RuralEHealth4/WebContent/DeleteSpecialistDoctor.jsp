<%@ page import="java.sql.*" %>>
<%@ page import="com.gd.health.*" %>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		try
{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps = con.prepareStatement("delete from specialistdoctor where name=? and email=?");
			ps.setString(1, request.getParameter("name"));
			ps.setString(2,request.getParameter("gmail"));
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

%>>
</body>
</html>