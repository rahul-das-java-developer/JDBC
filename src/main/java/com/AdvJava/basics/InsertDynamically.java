package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDynamically {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url, user, pwd);
				String sql="INSERT into student values(?,?,?)";
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 110);
				pstmt.setString(2, "Roronoa Zoro");
				pstmt.setInt(3, 28);
				
				pstmt.execute();
				System.out.println("Data inserted");
				
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
