package com.Cubic.DBProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class UpdateUserNameDemo {
	public static void UpdateDemo(Connection con) throws Exception{
		Scanner sc=new Scanner(System.in);
		PreparedStatement pst=con.prepareStatement("select * from empdata");
		ResultSet rs=pst.executeQuery();
		HashSet<String> hs=new HashSet<>();
		while(rs.next())
		{
		hs.add(rs.getString("ename"));
		}
		System.out.println("Enter Employee Name");
		String name=sc.next();
		if(hs.contains(name)) {
			System.out.println("Records Found");
		PreparedStatement pst1=con.prepareStatement("update empdata set eno=?,ename=?,emailid=?,esal=?,edept=? where ename=?");
		System.out.println("Enter Employee number");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Mailid");
		String mail=sc.next();
		System.out.println("Enter Employee Salary");
		int sal=sc.nextInt();
		System.out.println("Enter Employee Department");
		String dept=sc.next();
		System.out.println("Enter User name");
		String name1=sc.next();
		pst1.setInt(1, eno);
		pst1.setString(2, name1);
		pst1.setString(3, mail);
		pst1.setInt(4, sal);
		pst1.setString(5, dept);
		pst1.setString(6, name);
		int i=pst1.executeUpdate();
		if(i==1) {
			System.out.println("Records updated");
		}else
			System.out.println("Records Not Updated");
		}
		else
			System.out.println("Records Not Found");
		sc.close();
	}
}
