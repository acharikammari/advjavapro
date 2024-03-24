package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//step1: load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver loaded successfully.....");
		
		//step2: create the connection
		
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("connection created succefully......");
			
			//step3:process the query
				Statement statement=connection.createStatement();
				String q1="create table emp(id number,name varchar2(30),salary number)";
				int res1=statement.executeUpdate(q1);
				System.out.println("table created sucessfully"+res1);
			
				/*String q2="drop table emp";
				int res2=statement.executeUpdate(q2);
				System.out.println("teble droped succesuffyl......."+res2);*/
			
		//step4:release the resources
			connection.close();
			System.out.println("conncetion closed successfully.....");
			
	}

}
