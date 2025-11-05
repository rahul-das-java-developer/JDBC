package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDataBasedOnCondition {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url,user,pwd);
//				String sql="SELECT * from principal";
//				String sql="SELECT name from principal"; //name			
//				String sql="SELECT name,age from principal"; //name & age
				
				String sql="SELECT age from principal where age>=32"; 
				
				Statement stmt=connection.createStatement();
				
				ResultSet executeQuery = stmt.executeQuery(sql);
				
				while(executeQuery.next())
				{
//					System.out.println("PRINCIPAL ID: "+executeQuery.getInt(1));
//					System.out.println("PRINCIPAL NAME: "+executeQuery.getString(2));
//					System.out.println("PRINCIPAL AGE: "+executeQuery.getInt(3));
//					System.out.println("PRINCIPAL SALARY: "+executeQuery.getInt(4));
//					System.out.println("PRINCIPAL GENDER: "+executeQuery.getString(5));
//					System.out.println("PRINCIPAL CONTACT NO: "+executeQuery.getLong(6));
//					System.out.println("PRINCIPAL ADDRESS: "+executeQuery.getString(7));
					
//					System.out.println("PRINCIPAL NAME: "+ executeQuery.getString(1));	// Based on names
					
//					System.out.println("PRINCIPAL NAME: "+executeQuery.getString(1)+" and AGE: "+executeQuery.getInt(2));	// Based on name and age
					
					System.out.println("PRINCIPAL AGE(>=32): " +executeQuery.getInt(1));
					
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
