package com.sathya.selvlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		//read the  from form data
		
		String proId=request.getParameter("proId");
		String updateproName=request.getParameter("proName");
		
		double updateproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updateproBrand=request.getParameter("proBrand");
		String updateproMadeIn=request.getParameter("proMadeIn");
		
		Date updateproMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date updateproExpDate=Date.valueOf(request.getParameter("proExpDate"));

		
	//using above details create the product object
		Product prodct=new Product();
		prodct.setProId(proId);
		prodct.setProName(updateproName);
		
		prodct.setProPrice(updateproPrice);
		prodct.setProBrand(updateproBrand);
		prodct.setProMadeIn(updateproMadeIn);
		
		prodct.setProMfgDate(updateproMfgDate);
		prodct.setProExpDate(updateproExpDate);
		
		
		Part filepart=request.getPart("newproImage");

		//"newProimage" is the name of your file input field
		
		if(filepart !=null && filepart.getSize()>0)
		{
			InputStream inputStream=filepart.getInputStream();
			byte[] newproImageData = IOUtils.toByteArray(inputStream);
			prodct.setProImage(newproImageData);
		}
		else
		{	String file=request.getParameter("existingImage");
			byte[] existingImageData = Base64.getDecoder().decode(file);
			prodct.setProImage(existingImageData);
	
		}
		
		ProductDao Dao=new ProductDao();
		
	
		int result= Dao.updateById(prodct);
		if(result==1)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.forward(request, response);
			
			
		}
	}

}