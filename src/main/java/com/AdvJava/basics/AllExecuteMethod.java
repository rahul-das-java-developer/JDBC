package com.AdvJava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllExecuteMethod {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";

	public static void main(String[] args) {

		
			try {
				Class.forName("org.postgresql.Driver");
				
				try {
					Connection con=DriverManager.getConnection(url);
					String sql1="insert into student values(115,'Minato Namikaze',45)";
					String sql2="update student set name='Vinsmoke Sanji' where id=111";
					String sql3="delete from student where id=,117";
					String sql4="select * from student";
					
					
					Statement stmt = con.createStatement();
					
					//----------------execute()----------------//
					
//					boolean execute1 = stmt.execute(sql1);
//					boolean execute2 = stmt.execute(sql2);
//					boolean execute3 = stmt.execute(sql3);
//					boolean execute4 = stmt.execute(sql4);
//					
//
//					System.out.println(execute1);
//					System.out.println(execute2);
//					System.out.println(execute3);
//					System.out.println(execute4);
					
					//----------------execute()----------------//
					
					//----------------executeQuery()----------------//
					
//					ResultSet rs1 = stmt.executeQuery(sql1);
//					while(rs1.next())
//					{
//						System.out.println("STUDENT ID: "+rs1.getInt(1));
//						System.out.println("STUDENT NAME: "+rs1.getString(2));
//						System.out.println("STUDENT AGE: "+rs1.getInt(3));
//						System.out.println("------------------------");
//					}
//					
//					ResultSet rs2 = stmt.executeQuery(sql2);
//					while(rs2.next())
//					{
//						System.out.println("STUDENT ID: "+rs2.getInt(1));
//						System.out.println("STUDENT NAME: "+rs2.getString(2));
//						System.out.println("STUDENT AGE: "+rs2.getInt(3));
//						System.out.println("------------------------");
//					}
//					
//					ResultSet rs3 = stmt.executeQuery(sql3);
//					while(rs3.next())
//					{
//						System.out.println("STUDENT ID: "+rs3.getInt(1));
//						System.out.println("STUDENT NAME: "+rs3.getString(2));
//						System.out.println("STUDENT AGE: "+rs3.getInt(3));
//						System.out.println("------------------------");
//					}
//					
//					ResultSet rs4 = stmt.executeQuery(sql4);
//					while(rs4.next())
//					{
//						System.out.println("STUDENT ID: "+rs4.getInt(1));
//						System.out.println("STUDENT NAME: "+rs4.getString(2));
//						System.out.println("STUDENT AGE: "+rs4.getInt(3));
//						System.out.println("------------------------");
//					}
					
					//----------------executeQuery()----------------//
					
					//----------------executeUpdate()----------------//
					
//					int exUpdt1 = stmt.executeUpdate(sql1);
//					int exUpdt2 = stmt.executeUpdate(sql2);
//					int exUpdt3 = stmt.executeUpdate(sql3);
//					int exUpdt4 = stmt.executeUpdate(sql4);
					
//					System.out.println(exUpdt1);
//					System.out.println(exUpdt2);
//					System.out.println(exUpdt3);
//					System.out.println(exUpdt4);
					
					//----------------executeUpdate()----------------//
					
					//----------------executeBatch()----------------//
					
					int[] executeBatch = stmt.executeBatch();
					
					//----------------executeBatch()----------------//
					
					
					
					
					
					
					con.close();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		

	}

}
