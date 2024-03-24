package com.sathya.selvlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {

		public int save(Product product)
		{
		//Declare the resources
		Connection connection=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			//get the connection
			connection =Dbconnection.createConnection();
			//create the ps object
			ps=connection.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?,?)");
			
			//read the data from product object and set to parameters 
			ps.setString(1,product.getProId());
			ps.setString(2,product.getProName());
			
			ps.setDouble(3,product.getProPrice());
			ps.setString(4,product.getProBrand());
			ps.setString(5,product.getProMadeIn());
			
			ps.setDate(6,product.getProMfgDate());
			ps.setDate(7,product.getProExpDate());
		
			ps.setBytes(8,product.getProImage());
			ps.setBytes(9,product.getProAudio());
			ps.setBytes(10,product.getProVideo());

			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			//before release connection check the connection preset or no
			try{
				if (connection!=null)
					
					
					connection.close();
			
				if(ps!=null)
				
					ps.close();
			}
			catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
		return count;
	}
		
		public List<Product> findAll()
		{
				List<Product> lp=new ArrayList<Product>();
			
			try(Connection connection=Dbconnection.createConnection();
					Statement statement= connection.createStatement())
			{
				//exicute query
				
				ResultSet resultset= statement.executeQuery("select*from product");
				
				while(resultset.next())
					
				{	
					//set the data  to resultset object   
					Product p1=new Product();		
					
					p1.setProId(resultset.getString(1));
					p1.setProName(resultset.getString(2));
					
					p1.setProPrice(resultset.getDouble(3));
					p1.setProBrand(resultset.getString(4));
					p1.setProMadeIn(resultset.getString(5));
					
					p1.setProMfgDate(resultset.getDate(6));
					p1.setProExpDate(resultset.getDate(7));

					p1.setProImage(resultset.getBytes(8));
					p1.setProAudio(resultset.getBytes(9));
					p1.setProVideo(resultset.getBytes(10));

				//add the data from resultset to products object 
					lp.add(p1);	
				}	
			}
			catch(SQLException e)
				{
				e.printStackTrace();
				}
				return lp;
			}
		
		// delete by id method
		
				public int deleteById(String proId)
				{
					int Dcount=0;
					try(Connection connection=Dbconnection.createConnection();
						PreparedStatement preparedStatement=connection.prepareStatement("delete from product where proId=?"))
					{
						//set the data to parameter
						preparedStatement.setString(1, proId);
						//execute the query
						Dcount=preparedStatement.executeUpdate();
						
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				return Dcount;
				}
				
				//findById method
				
				public Product findById(String proId) 
				{
					Product product=null;
					
					try(Connection connection=Dbconnection.createConnection();
							PreparedStatement preparedStatement=connection.prepareStatement("select * from product where proId=?"))
					{
						//set the data to parameter
						preparedStatement.setString(1,proId);
						//execute the query
						ResultSet resultSet=preparedStatement.executeQuery();
						
						if(resultSet.next()) 
							{
							//read the data from resultSet setting to Products
								
							product=new Product();
							product.setProId(resultSet.getString(1));
							product.setProName(resultSet.getString(2));
							
							product.setProPrice(resultSet.getDouble(3));
							product.setProBrand(resultSet.getString(4));
							product.setProMadeIn(resultSet.getString(5));
							
							product.setProMfgDate(resultSet.getDate(6));
							product.setProExpDate(resultSet.getDate(7));
							product.setProImage(resultSet.getBytes(8));
							

							}
					}
					
					catch(SQLException e)
						{
							e.printStackTrace();
						
						}
					return product;
						
				}
		
		//updateById method
				
				public int updateById(Product product)

				{
					String sql="UPDATE product SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=? WHERE proId=?";
					int updateResult=0;
					try(Connection connection=Dbconnection.createConnection();
						PreparedStatement preparedStatement=connection.prepareStatement(sql))
					{
						preparedStatement.setString(1, product.getProName());

						preparedStatement.setDouble(2, product.getProPrice());
						preparedStatement.setString(3, product.getProBrand());
						preparedStatement.setString(4, product.getProMadeIn());
						preparedStatement.setDate(5, product.getProMfgDate());
						preparedStatement.setDate(6, product.getProExpDate());
						preparedStatement.setBytes(7, product.getProImage());
						
						preparedStatement.setString(8, product.getProId());
						updateResult=preparedStatement.executeUpdate();
		
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					return updateResult;
				}
		



}