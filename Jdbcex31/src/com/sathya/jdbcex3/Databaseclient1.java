package com.sathya.jdbcex3;

import java.util.List;

public class Databaseclient1  {

	public static void main(String[] args)
	{
		ProductDao productDao=new ProductDao();
		/*int res1=productDao.saveProduct(new Product(11,"HDD",500));
		System.out.println("Data inserted sucessfully"+res1);
		
		int res2=productDao.saveProduct(new Product(12,"Motheboard",1000));
		System.out.println("Data inserted sucessfully"+res2);
		
		int res3=productDao.saveProduct(new Product(13,"processor",500));
		System.out.println("Data inserted sucessfully"+res3);*/
		

		//read the data from database
		
		//Product product=productDao.getProductById(11);
		//System.out.println(product);
		
		//List<Product>products=productDao.getAllProducts();
		//products.forEach(product->System.out.println(products));
		
		/*int deletecount = productDao.deletebyId(13);
	 	if(deletecount==1)
	 	{
	 		System.out.println("Data deleted successfully....");
	 	}
	 	else
	 	{
	 		System.out.println("data deletion fail...");
	 	}*/
	 	
	 	//int deletecount = productDao.deletebyId(11);
	 	 //System.out.println("data deleted");
		
		int updatecount=productDao.updateByPrice(200, 100);
		System.out.println("Price updated....."+updatecount);
		
		
		
		
		
		
	}

}
