package jdbcex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao 
{
	public int save(Employee emp)
	{
		//Declaration the resources
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		int count=0;
		try
		{
		// Get the connection
		
		connection=DbConnection.createConnection();
		//create the prepardstatement object
		
		preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
		//read the data from emplouee object and set to parameters
		preparedStatement.setInt(1,emp.getEmpId());
		preparedStatement.setString(2, emp.getEmpName());
		preparedStatement.setDouble(3, emp.getEmpSalary());
		count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//before release connection check the connection present(or) not
			if(connection!=null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try 
				{
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
			}
		}
		return count;
	}
public Employee findById(int empId)
	{
		Employee employee = null;
		try(Connection connetion=DbConnection.createConnection();
			PreparedStatement preparedStatement=connetion.prepareStatement("select *from emp where empId=?"))
		{
			//set the data to parameter
			preparedStatement.setInt(1, empId);
			//exceute the query
			ResultSet resultSet=preparedStatement.executeQuery();
			//if the record is present execute below code,if the record is not present it returns null
			if(resultSet.next())
			{
				employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	public int deleteById(int empId)
	{
		int count=0;
		
		try(Connection connetion=DbConnection.createConnection();
				PreparedStatement preparedStatement=connetion.prepareStatement("delete from emp where empId=?"))
				
		{
			//set the data to parameter
			preparedStatement.setInt(1, empId);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public int deleteBySalary(double empSalary)
	{
			 int count=0;
		
		try(Connection connetion=DbConnection.createConnection();
				PreparedStatement preparedStatement=connetion.prepareStatement("delete from emp where empSalary>=?"))
				
		{
			//set the data to parameter
			preparedStatement.setDouble(1, empSalary);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public List<Employee> findAll()
	{
		List<Employee> emps=new ArrayList<Employee>();
		
		try(Connection connetion=DbConnection.createConnection();
			Statement statement=connetion.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select *from emp");
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emps.add(employee);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emps;
	}
	public int updateSalary(double currentSalary ,double incSalary)
	{
		   int updatecount=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update emp set empSalary=empSalary+?where empSalary>=?"))
		{
				//set the data into parameter
			preparedStatement.setDouble(1, incSalary);
			preparedStatement.setDouble(2, currentSalary);
			
			 updatecount=preparedStatement.executeUpdate();
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updatecount;
		
	}
}
	
