package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMultipleData {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url, user, pwd);
				String sql="UPDATE principal set name=?, contact=? where id=? ";
				
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, "Monkey D. Luffy");
				pstmt.setLong(2, 9800428444l);
				pstmt.setInt(3, 102);
				pstmt.addBatch();
				
				pstmt.setString(1, "Vinsmoke Sanji");
				pstmt.setLong(2, 9836412583l);
				pstmt.setInt(3, 103);
				pstmt.addBatch();
				
				pstmt.setString(1, "Naruto Uzumaki");
				pstmt.setLong(2, 9800428444l);
				pstmt.setInt(3, 104);
				pstmt.addBatch();
				
				pstmt.setString(1, "Tony Tony Chopper");
				pstmt.setLong(2, 9800428444l);
				pstmt.setInt(3, 105);
				pstmt.addBatch();
				
				
				pstmt.executeBatch();
				System.out.println("Data updated");

				
				connection.close();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}


