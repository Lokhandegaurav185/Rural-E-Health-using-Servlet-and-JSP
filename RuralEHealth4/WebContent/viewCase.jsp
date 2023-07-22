<%@ page import="java.sql.*" %>>
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
      <th scope="col">age</th>
      <th scope="col">address</th>
        <th scope="col">gender</th>
          <th scope="col">mobile</th>
            <th scope="col">symp1</th>
            <th scope="col">symp2</th>
            <th scope="col">symp3</th>
            <th scope="col">disease</th>
            <th scope="col">asignDoctor</th>
    </tr>
  </thead>
  <tbody>
  <%
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
  
  
	try
	{
		Connection con = ConnectDB.getConnect();
		PreparedStatement ps= con.prepareStatement("select * from case_tbl");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		%>
    <tr>
      <td><%=rs.getInt(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(5) %></td>
      <td><%=rs.getString(6) %></td>
      <td><%=rs.getString(7) %></td>
      <td><%=rs.getString(8) %></td>
      <td><%=rs.getString(9) %></td>
      <td><%=rs.getString(10) %></td>
      <td><%=rs.getString(11) %></td>
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
<a><a href="OpreationOnCase">view again</a></a>
</body>
</html>