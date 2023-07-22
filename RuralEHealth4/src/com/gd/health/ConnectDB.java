package com.gd.health;
import java.sql.*;
public class ConnectDB {
	
	static Connection con = null;
	public static Connection getConnect(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-heath", "root", "");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return con;
	}
}

