package com.ghri.Faccebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewAllProfiles
{

	public static void main(String[] args)
	{
		signup s=new signup();
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","root");
			Scanner sc=new Scanner(System.in);
		//System.out.println("Enter name or characters to search your profile");
			//String nameToSearch=sc.next();
			PreparedStatement prepareStmt=con.prepareStatement("select * from signup");
		//	prepareStmt.setString(1,nameToSearch);
			ResultSet rs=prepareStmt.executeQuery();
			while(rs.next())
			{
			
				String name=rs.getString(1);
				String email=rs.getString(2);
				String address=rs.getString(3);
				Long contact=rs.getLong(4);
				int age=rs.getInt(5);
				String gender=rs.getString(6);	
				
				s.setname(name);
				s.setemail(email);
				s.setaddress(address);
				s.setcontact(contact);
				s.setage(age);
				s.setgender(gender);
				System.out.println(name+"    "+email+"    "+address+"    "+contact+"    "+age+"    "+gender);
			}	
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

	}

}
