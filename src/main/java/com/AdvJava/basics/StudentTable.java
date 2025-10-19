package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";

	public static void main(String[] args) {

		// Step 1: load and register Driver class

		try {
			Class.forName("org.postgresql.Driver");

			// Step 2: Establish Connection

			try {
				Connection connection = DriverManager.getConnection(url, user, password);
				
				String sql = "INSERT into student values(105,'Naruto',22)";	// Insert
//				String sql = "UPDATE student set name='Zoro' where id=102";	// Update
//				String sql = "DELETE from student where id=102";	// Delete

				// Step 3: Create statement

				Statement stm = connection.createStatement();

				// Step 4: Execute query

				stm.execute(sql);
				System.out.println("Data stored");

				// Step 5: Close connection

				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
