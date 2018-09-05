package com.Cubic.DBProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBMain {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "reddy", "reddy");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter U'R choice From Bellow");
		System.out.println("1.insert");
		System.out.println("2.show");
		System.out.println("3.update");
		System.out.println("4.delete");
		System.out.println("5.Update Special");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
		CrudOperation.insert(con);
		break;
		case 2:
		CrudOperation.show(con);
		break;
		case 3:
		CrudOperation.update(con);
		break;
		case 4:
		CrudOperation.delete(con);
		break;
		case 5:
			UpdateUserNameDemo.UpdateDemo(con);
			break;
		default:
			System.out.println("invalid Selection");
		}
		con.close();
	}
}
