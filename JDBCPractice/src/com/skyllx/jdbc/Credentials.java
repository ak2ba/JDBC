package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Credentials {
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/skyllx";
	private static String un = "root";
	private static String pwd = "password";
	
	public static Connection establishConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");

			//establishing the conneciton
			con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection established at "+con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(ResultSet rs,Statement stmt,Connection con)
	{
		try {
			if(rs!=null)
			{
				rs.close();
				System.out.println("RS closed");
			}
			if(stmt!=null)
			{
				stmt.close();
				System.out.println("STMT closed");
			}
			if(con!=null) 
			{
				con.close();
				System.out.println("CON closed");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
