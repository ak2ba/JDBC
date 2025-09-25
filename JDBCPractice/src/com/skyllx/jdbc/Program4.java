package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Program4 
{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;

	public static void main(String []args) 
	{
		try 
		{
			// loading and establishing connection
			con = Credentials.establishConnection();
			
			String s = "select * from employee";
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(s);
			rsmd = rs.getMetaData();
			
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnTypeName(i));
				System.out.println(rsmd.getColumnDisplaySize(i));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}









