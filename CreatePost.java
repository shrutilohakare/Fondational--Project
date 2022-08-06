package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CreatePost {
	

	public static void main(String[] args)
	{

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","root");	
			Scanner sc=new Scanner(System.in);
			System.out.println("Post Message");
			String postmess=sc.next();
			String uemail=sc.next();
			int posttime =sc.nextInt();
			int post=sc.nextInt();
			
			PreparedStatement prepareStmt=con.prepareStatement("insert into fbpostvalues (?, ?, ?, ?)");
			prepareStmt.setString(1,postmess);
			prepareStmt.setString(2,uemail);
			prepareStmt.setInt(3, posttime);
			prepareStmt.setInt(4, post);
			
			if(prepareStmt.executeUpdate()==1)
				System.out.println("Message Posted");
			
			//System.out.println("listing all the rows in student table");
			//ResultSet rs =prepareStmt.executeQuery("select * from student");
			//printResultSet(rs);
			
		}
		
		catch(Exception e)
		{
			System.out.println();
		}
	}

}
