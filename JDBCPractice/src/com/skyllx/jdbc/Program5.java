package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program5 
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
			
			String s = "update skyllxstudent set email=? where sid=?";
			//prepare a sttmt
			pstmt = con.prepareStatement(s);
			
			System.out.println("Enter the new email id: ");
			String email = sc.nextLine();
			System.out.println("Enter the Student ID");
			int sid = sc.nextInt();
			pstmt.setString(1, email);
			pstmt.setInt(2, sid);
			int x = pstmt.executeUpdate();
			System.out.println(x+" rows affected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}









