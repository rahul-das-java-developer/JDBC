
package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchDynamically {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection connection = DriverManager.getConnection(url, user, pwd);
				String sql="select * from principal where age>=?";
				
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 26);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("PRINCIPAL ID: "+rs.getInt(1));
					System.out.println("PRINCIPAL NAME: "+rs.getString(2));
					System.out.println("PRINCIPAL AGE: "+rs.getInt(3));
					System.out.println("PRINCIPAL SALARY: "+rs.getInt(4));
					System.out.println("PRINCIPAL GENDER: "+rs.getString(5));
					System.out.println("PRINCIPAL CONTACT NO: "+rs.getLong(6));
					System.out.println("PRINCIPAL ADDRESS: "+rs.getString(7));
					System.out.println("------------------------------------------------------------");
				}
				
				System.out.println("Data fetched");
				
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}



