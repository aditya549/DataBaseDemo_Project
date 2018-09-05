package com.Cubic.DBProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class CrudOperation {
	public static void insert(Connection con) throws Exception {
		//Connection con=DBMain.getCon();
		PreparedStatement pst=con.prepareStatement("insert into empdata(eno,ename,emailid,esal,edept) values(?,?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee number");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc.next();
		System.out.println("Enter Employee Mailid");
		String mail=sc.next();
		System.out.println("Enter Employee Salary");
		int sal=sc.nextInt();
		System.out.println("Enter Employee Department");
		String dept=sc.next();
		pst.setInt(1, eno);
		pst.setString(2, name);
		pst.setString(3, mail);
		pst.setInt(4, sal);
		pst.setString(5, dept);
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("Records Inserted");
		}else
			System.out.println("Records Not Inserted");
		sc.close();
	}
	public static void show(Connection con){
		try {
		PreparedStatement pst=con.prepareStatement("select * from empdata");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("eno")+".."+rs.getString("ename")+".."+rs.getString("emailid")+".."+rs.getInt("esal")+".."+rs.getString("edept"));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public static void update(Connection con) throws Exception {
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
		PreparedStatement pst1=con.prepareStatement("update empdata set eno=?,emailid=?,esal=?,edept=? where ename=?");
		System.out.println("Enter Employee number");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Mailid");
		String mail=sc.next();
		System.out.println("Enter Employee Salary");
		int sal=sc.nextInt();
		System.out.println("Enter Employee Department");
		String dept=sc.next();
		pst1.setInt(1, eno);
		pst1.setString(2, mail);
		pst1.setInt(3, sal);
		pst1.setString(4, dept);
		pst1.setString(5, name);
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
	public static void delete(Connection con)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name to Delete Record");
		String name=sc.next();
		PreparedStatement pst=con.prepareStatement("delete from empdata where ename=?");
		pst.setString(1, name);
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("Record Deleted");
		}else
			System.out.println("Record not deleted");
		sc.close();
	}
}