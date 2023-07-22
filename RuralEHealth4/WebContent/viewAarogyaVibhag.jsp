<%@ page import="java.sql.*" %>
<%@ page import="com.gd.health.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
					       <table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">mobile</th>
      <th scope="col">email</th>
        <th scope="col">village</th>
          <th scope="col">district</th>
            <th scope="col">taluka</th>
    </tr>
  </thead>
  <tbody>
  <%
	
	try
	{
		Connection con = ConnectDB.getConnect();
		PreparedStatement ps= con.prepareStatement("select * from aarogyavibhag");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		%>
    <tr>
      <th><%=rs.getInt(1) %></th>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(5) %></td>
      <td><%=rs.getString(6) %></td>
      <td><%=rs.getString(7) %></td>
      <td><%=rs.getString(8) %></td>
    </tr>
    <% 
  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	%>
  </tbody>

</table>
								
	
	
	
</body>
</html>