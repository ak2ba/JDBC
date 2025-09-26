package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program6
{
	private static Connection con;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public static void main(String []args) 
	{
		Scanner sc = new Scanner(System.in);
		try 
		{
			// loading and establishing connection
			con = Credentials.establishConnection();
			
			String s = "delete from skyllxstudent where sid=?";
			//prepare a sttmt
			pstmt = con.prepareStatement(s);
			
			System.out.println("Enter the Student ID");
			int sid = sc.nextInt();
			
			pstmt.setInt(1, sid);
			int x = pstmt.executeUpdate();
			System.out.println(x+" rows deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}









