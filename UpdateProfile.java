package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProfile 
{
	public static void main(String[] args)
	{
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","root");	
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Email id");
			String emailToUpdate=sc.next();
			
			System.out.println("Enter name to update");
			String newName=sc.next();
			
			System.out.println("Enter address to update");
			String newAddress=sc.next();
			
			System.out.println("Enter contact number to update");
			Long newContact=sc.nextLong();
			
			System.out.println("Enter age to update");
			int newage=sc.nextInt();
			
			System.out.println("Enter gender to update");
			String newGender=sc.next();
			
			System.out.println("Enter password to update");
			String newPswd=sc.next();
			
			PreparedStatement prepareStmt=con.prepareStatement("update signup set name =?, address=? , contact=? ,age=? , gender=? , pswd=? where email = ?");
			prepareStmt.setString(1, newName);
			prepareStmt.setString(2, newAddress);
			prepareStmt.setLong(3, newContact);
			prepareStmt.setInt(4, newage);
			prepareStmt.setString(5, newGender);
			prepareStmt.setString(6, newPswd);
			prepareStmt.setString(7, emailToUpdate);
			
			if(prepareStmt.executeUpdate()==1)
				System.out.println("Record Updated");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
