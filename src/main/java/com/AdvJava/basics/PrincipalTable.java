package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalTable {
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
				
				String sql = "INSERT into principal values(106,'RAHUL',26,530000,'M',9800000001,'DANTAN'),(104,'RAHUL',39,630000,'M',9800000002,'WEST BANGAL'),(105,'Gara',31,730000,'M',9800000003,'BANGALORE')";	// Insert	
//				String sql = "UPDATE principal set name='Nami',gender='F',age=28 where id=101";	// Update
//				String sql = "DELETE from principal where id=101";	// Delete

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
