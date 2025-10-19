
package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDynamically {
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
				pstmt.setString(1, "Naruto Uzumaki");
				pstmt.setLong(2, 9800428444l);
				pstmt.setInt(3, 102);
				pstmt.execute();
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

