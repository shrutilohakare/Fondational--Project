package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteProfile 
{

	public static void main(String[] args) 
	{
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","root");	
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter email to delete your account");
			String emailToDelete=sc.next();
			PreparedStatement prepareStmt=con.prepareStatement("delete from signup where email=?");
			prepareStmt.setString(1,emailToDelete);
			
		if(prepareStmt.executeUpdate()==1)
		{
		System.out.println("Account deleted successfully");
		}
		else
		{
			System.out.println("You do not have account associated with this email ");
		}
			
			/*
			ResultSet rs=prepareStmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Account Deleted Successfully");
			}	
			else
			{
				System.out.println("You do not have account associated with this email ");
			}
			*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
