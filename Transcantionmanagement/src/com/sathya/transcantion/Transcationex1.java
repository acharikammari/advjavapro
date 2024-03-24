package com.sathya.transcantion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transcationex1 {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			statement=connection.createStatement();
			
			connection.setAutoCommit(false);
			
			statement.executeUpdate("insert into emp values(1003,'ashok',1000.45)");
			statement.executeUpdate("insert into emp values(1004,'ani',2000.45)");
			statement.executeUpdate("insert into emp values(1005,'anish',3000.45)");
			statement.executeUpdate("delete from emp where EMPID=1003");
			
			System.out.println("transcantion success");
			connection.commit();
		}
		catch(ClassNotFoundException |SQLException e)
		{
			System.out.println("transation fail");
			connection.rollback();
			e.printStackTrace();
		}
		finally
		{
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		}
	}

}
