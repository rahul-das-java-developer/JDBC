package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleData {
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
				
				pstmt.setInt(1, 111);
				pstmt.setString(2, "Sanji");
				pstmt.setInt(3, 26);
				pstmt.addBatch();
				
				pstmt.setInt(1, 112);
				pstmt.setString(2, "Nami");
				pstmt.setInt(3, 24);
				pstmt.addBatch();
				
				pstmt.setInt(1, 113);
				pstmt.setString(2, "Shisui Uchiha");
				pstmt.setInt(3, 19);
				pstmt.addBatch();
				
				int[] a = pstmt.executeBatch();
				System.out.println("Data inserted");
				
				for(int i:a)
				{
					System.out.println("row no effected: "+i);
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
