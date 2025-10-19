package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllQueries {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	private static Connection con;
	private static Statement stmt;
	private static Scanner scn=new Scanner(System.in);	
	

	public static void main(String[] args) {
		
		
		try {
			con = DriverManager.getConnection(url);
			
			stmt = con.createStatement();
			
//			insertData();
//			updateData();
//			deleteData();
			fetchData();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void insertData() {
		
		System.out.println("Enter student sid: ");
		int sid=scn.nextInt();
		scn.nextLine();		//	From ChatGPT
		System.out.println("Enter student name: ");
		String name=scn.nextLine();
		System.out.println("Enter student java marks: ");
		int javaMarks=scn.nextInt();
		System.out.println("Enter student web marks: ");
		int webMarks=scn.nextInt();
		System.out.println("Enter student sql marks: ");
		int sqlMarks=scn.nextInt();
		
		String insertQuery="insert into marksheet values("+sid+",'"+name+"',"+javaMarks+","+webMarks+","+sqlMarks+")";
		try {
			stmt.execute(insertQuery);
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateData() {
		System.out.println("Enter the modified student name: ");
		String name=scn.nextLine();
		System.out.println("Enter the modified student sid: ");
		int id=scn.nextInt();
		
		String updateQuery="update marksheet set name= '"+name+"' where sid= "+id ;		
		try {
			stmt.execute(updateQuery);
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteData() {
		System.out.println("Enter deleted student sid: ");
		int id=scn.nextInt();
		String deleteQuery="delete from marksheet where sid= "+id ;
		try {
			stmt.execute(deleteQuery);
			System.out.println("Data deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fetchData() {
		String fetchQString="select * from marksheet";
		try {
			ResultSet executeQuery = stmt.executeQuery(fetchQString);
			System.out.println("SID\tSTUDENT NAME\t\tJAVA\t\tWEB\t\tSQL");
			
			while(executeQuery.next())
			{
								
				System.out.println("--------------------------------------------------------------------------------------------------");
				System.out.print(executeQuery.getInt(1)+"\t"+executeQuery.getString(2)+"\t\t"+executeQuery.getInt(3)+"\t\t"+executeQuery.getInt(4)+"\t\t"+executeQuery.getInt(5)+"\n");
				
//				System.out.println("------------------------------------------------------------------------------------------");
//				System.out.println("Student id: "+executeQuery.getInt(1)+", \tName: "+executeQuery.getString(2)+", \tJava mark: "+executeQuery.getInt(3)+", \tWeb mark: "+executeQuery.getInt(4)+", \tSQL mark: "+executeQuery.getInt(5));
				
			}
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("Data fetched");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
