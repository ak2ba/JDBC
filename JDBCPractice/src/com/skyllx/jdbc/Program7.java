package com.skyllx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program7 {
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
			
			//prepare the statement
			String s = "INSERT into skyllxstudent(sid,sname,email,mobile) values(?,?,?,?)";
			pstmt = con.prepareStatement(s);
			
			for(int i=1;i<=3;i++)
			{
				System.out.println("Enter the sid");
				int sid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the s_name");
				String s_name = sc.nextLine();
				System.out.println("Enter the email");
				String email = sc.nextLine();
				System.out.println("Enter the mobile");
				int mobile = sc.nextInt();
				
				pstmt.setInt(1, sid);
				pstmt.setString(2, s_name);
				pstmt.setString(3, email);
				pstmt.setInt(4, mobile);
				
				//execute the statement
				pstmt.executeUpdate();
				System.out.println(i+" rows affected");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			Credentials.closeConnection(rs, pstmt, con);
		}
	}
}
