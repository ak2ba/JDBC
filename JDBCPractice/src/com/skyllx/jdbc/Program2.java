package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program2 {
	private static Connection con;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public static void main(String[] args)
	{		
		try {
			con = Credentials.establishConnection();
			
			//create a statement
			String s = "select * from skyllxstudent where sid=?";
			pstmt = con.prepareStatement(s);
			System.out.println("Statement is created");
			System.out.println("Enter the ID of student");
			pstmt.setInt(1, new Scanner(System.in).nextInt());
			//execute the statement
			rs = pstmt.executeQuery();
			System.out.println("ResultSet is created");

			//process the result
			while(rs.next())
			{
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String email = rs.getString(3);
				int mobile = rs.getInt(4);

				System.out.println(sid+"   "+sname+"   "+email+"   "+mobile);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Credentials.closeConnection(rs, pstmt, con);
		}
	}
}
















