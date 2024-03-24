package com.sathya.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class procedureexecutionex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager"); 
		
		//call the procedure
		CallableStatement callableStatement=connection.prepareCall("{call getSal(?,?)}");
		
		//set the input
		callableStatement.setInt(1, 1003);
		
		//register one variable to store the output
		callableStatement.registerOutParameter(2, Types.FLOAT);
		
		//execute the procedure the output will be store in e=registered parameter
			callableStatement.executeUpdate();
		
		// print the output
			System.out.println(callableStatement.getFloat(2));
			
			connection.close();
    }

}
