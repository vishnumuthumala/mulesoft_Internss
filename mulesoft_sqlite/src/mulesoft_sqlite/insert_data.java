package mulesoft_sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

public class insert_data {
	public static void main(String[] args) {
		 try {
			 Class.forName("org.sqlite.JDBC");
			 String dbURL ="jdbc:sqlite:movies.db";
			 Connection conn=DriverManager.getConnection(dbURL);
			 if(conn!=null) {
				System.out.println("connection established successful");
				
				
				Scanner sc=new Scanner(System.in);
				 System.out.println("Enter movie name:");
				 String  mov_name=sc.next();
				 System.out.println("Enter actor name:");
				 String  actor=sc.next();
				 System.out.println("Enter actress name:");
				 String  actress=sc.next();
				 System.out.println("Enter year:");
				 int year=sc.nextInt();
				 
				PreparedStatement pt=conn.prepareStatement("insert into movies values(?,?,?,?)");
				 pt.setString(1, mov_name);
				 pt.setString(2, actor);
				 pt.setString(3, actress);
				 pt.setInt(4, year);
				 int n=pt.executeUpdate();
				 System.out.println(n);
				 
			
				
			 }
			 else {
				 System.out.println("not connected");
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	 }
}
