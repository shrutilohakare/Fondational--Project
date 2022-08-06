package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;
import com.mysql.cj.xdevapi.PreparableStatement;

public class registration 
{
	/*
	public static void printResultSet(ResultSet rs)throws Exception
	 {
		 while(rs.next())
			{
				String name=rs.getString(1);
				String email=rs.getString(2);
				String address=rs.getString(3);
				Long contact=rs.getLong(4);
				int age=rs.getInt(5);
				String gender=rs.getString(6);
				String pswd=rs.getString(7);
				
				System.out.println(name+" "+email+" "+address+" "+contact+" "+age+" "+gender+" "+pswd);					
			}	
		 
	 }
	*/
	 public static void main(String[] args)
	 {
		 try 
		 {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","root");	
			 Scanner sc=new Scanner(System.in);
			 
			 System.out.println("Enter Name");
			 String name=sc.next();
			 
			 System.out.println("Enter Email Id");
			 String email=sc.next();
			 
			 System.out.println("Enter Address");
			 String address=sc.next();
			 
			 System.out.println("Enter Contact Number");
			 Long contact=sc.nextLong();
			 
			 System.out.println("Enter Age");
			 int age=sc.nextInt();
			 
			 System.out.println("Enter Gender");
			 String gender=sc.next();
			 
			 System.out.println("Enter Password");
			 String pswd=sc.next();
			 
			 PreparedStatement prepareStmt=con.prepareStatement("insert into signup values (?, ?, ?, ?, ?, ?, ?)");
			 
			 prepareStmt.setString(1,name);
			 prepareStmt.setString(2,email);
			 prepareStmt.setString(3,address);
			 prepareStmt.setLong(4,contact);
			 prepareStmt.setInt(5,age);
			 prepareStmt.setString(6,gender);
			 prepareStmt.setString(7,pswd);
			 
			 if(prepareStmt.executeUpdate()==1)
			 System.out.println(":::::  Account Created successfully  :::::");
			 
			 			
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex);
		 }
	 }
}
