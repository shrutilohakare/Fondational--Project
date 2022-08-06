package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login
{
	public static void main(String[] args) 
	{
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root","root");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Login ID");
			String email=sc.next();
			
			System.out.println("Enter Password");
			String pswd=sc.next();
			

			PreparedStatement prepareStmt=con.prepareStatement("select * from signup where email=? and pswd=?");
			prepareStmt.setString(1,email);
			prepareStmt.setString(2, pswd);
			ResultSet rs=prepareStmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Login Successful");
			}	
			else
			{
				System.out.println("Login Failed");
			}
		}
		catch(Exception ex)
		{
		System.out.println(ex);
		}
	}
}
