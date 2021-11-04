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
				 String  m_name=sc.next();
				 System.out.println("Enter actor name:");
				 String  ac_name=sc.next();
				 System.out.println("Enter actress name:");
				 String  acs_name=sc.next();
				 System.out.println("Enter year:");
				 int yr_number=sc.nextInt();
				 
				PreparedStatement pt=conn.prepareStatement("insert into movies values(?,?,?,?)");
				 pt.setString(1, m_name);
				 pt.setString(2, ac_name);
				 pt.setString(3, acs_name);
				 pt.setInt(4, yr_number);
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
