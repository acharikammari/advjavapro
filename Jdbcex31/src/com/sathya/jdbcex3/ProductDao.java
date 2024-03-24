package com.sathya.jdbcex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class ProductDao 
{
		public int saveProduct(Product product)
		{
			//Declaration the resources
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			int count=0;
			try
			{
				connection=DbConnetion.createConnection();
				
				//create the prepardstatement object
				preparedStatement=connection.prepareStatement("insert into product values(?,?,?)");
				
				//read the data from product object and set to parameters
				preparedStatement.setInt(1,product.getProId());
				preparedStatement.setString(2,product.getProName());
				preparedStatement.setDouble(3,product.getProPrice());
				
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
public Product getProductById(int ProId)
 {
	 	Product product = null;
	 	try(Connection connetion=DbConnetion.createConnection();
		PreparedStatement preparedStatement=connetion.prepareStatement("select * from product where PROID=?"))
	 	{
	 		//set the data to parameter
	 		preparedStatement.setInt(1,ProId);
		
	 		//exceute the query
	 		ResultSet resultSet=preparedStatement.executeQuery();
		
	 		//if the record is present execute below code,if the record is not present it returns null
	 		if(resultSet.next())
	 		{
	 			 product = new Product();
	 			
	 			product.setProId(resultSet.getInt(1));
	 			product.setProName(resultSet.getString(2));
	 			product.setProPrice(resultSet.getDouble(3));
	 		}
	 	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	 	return product;
	}
public List<Product> getAllProducts()
	{
		List<Product> products=new ArrayList<Product>();
		try(Connection connetion=DbConnetion.createConnection();
				Statement statement=connetion.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select *from Product");
			while(resultSet.next())
			{
				Product product=new Product();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				products.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return products;
	}
public int deletebyId(int proId)
	{
		int count=0;
	
		try(Connection connetion=DbConnetion.createConnection();
				PreparedStatement preparedStatement=connetion.prepareStatement("delete from Product where PROID=?"))
			
		{
			//set the data to parameter
			preparedStatement.setInt(1,proId);
			count=preparedStatement.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
public int deleteByPrice(int ProPrice)
{
	int count=0;
	
	try(Connection connetion=DbConnetion.createConnection();
			PreparedStatement preparedStatement=connetion.prepareStatement("delete from Product where PROPRICE=?"))
	{
		
		//set the data to parameter
		preparedStatement.setDouble(1, ProPrice);
		count=preparedStatement.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return count;
}

public int updateByPrice(double currentPrice,double incPrice)
	{
		int updatecount=0;
		try(Connection connetion=DbConnetion.createConnection();
		PreparedStatement preparedStatement=connetion.prepareStatement("update Product set PROPRICE=PROPRICE+?where PROPRICE>=?"))
		{
			//set the data into parameter
		
			preparedStatement.setDouble(1, incPrice);
			preparedStatement.setDouble(2, currentPrice);
			updatecount=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updatecount;
	}
}
 
