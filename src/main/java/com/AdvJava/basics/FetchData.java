package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url,user,pwd);
				String sql="SELECT * from student where age=22";
				
				Statement stmt=connection.createStatement();
				
				ResultSet executeQuery = stmt.executeQuery(sql);
				
				while(executeQuery.next())
				{
					System.out.println("STUDENT ID: "+executeQuery.getInt(1));
					System.out.println("STUDENT NAME: "+executeQuery.getString(2));
					System.out.println("STUDENT AGE: "+executeQuery.getInt(3));
					System.out.println("------------------------");
				}
				
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		

	}

}
