package com.sathya.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcex3 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		Statement statement=connection.createStatement();
		String q1="create table product(proId number,proName varchar2(30),proPrice number)";
		int res1=statement.executeUpdate(q1);
		System.out.println("table created sucessfully:"+res1);
		
		/*String q2="drop table Product";
		int res2=statement.executeUpdate(q2);
		System.out.println("teble droped succesuffyl......."+res2);*/
		
		connection.close();

	}

}
