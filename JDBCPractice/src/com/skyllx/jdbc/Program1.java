package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	public static void main(String[] args)
	{		
		try {
			con = Credentials.establishConnection();
			
			//create a statement
			String s = "select * from skyllxstudent";
			stmt = con.createStatement();
			System.out.println("Statement is created");
			//execute the statement
			rs = stmt.executeQuery(s);
			System.out.println("ResultSet is created");

			//process the result
			while(rs.next())
			{
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String email = rs.getString("email");
				int mobile = rs.getInt("mobile");

				System.out.println(sid+"   "+sname+"   "+email+"   "+mobile);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Credentials.closeConnection(rs, stmt, con);
		}
	}
}
















