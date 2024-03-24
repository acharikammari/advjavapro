package com.sathya.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementexapmple {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		//call the function
		CallableStatement callableStatement=connection.prepareCall("{?= call getAvg(?,?)}");
		
		// set the input
		callableStatement.setInt(2, 1001);
		callableStatement.setInt(3, 1002);
		
		
		//register the store the output
		callableStatement.registerOutParameter(1, Types.DOUBLE);
		
		//execute the procedure the output will be store in register parameter

		callableStatement.executeUpdate();
		
		//get the output
		System.out.println(callableStatement.getDouble(1));
		
		connection.close();
		
		

	}

}
