package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMultipleData {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url, user, pwd);
				String sql="Delete from principal where id=? ";
				
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 104);
				pstmt.addBatch();
				
				pstmt.setInt(1, 106);
				pstmt.addBatch();
				
				pstmt.executeBatch();
				System.out.println("Data deleted");
				
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}


