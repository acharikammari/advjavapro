package com.sathya.selvlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read the  from form data
		
				String proId=request.getParameter("proId");
				String proName=request.getParameter("proName");
				
				double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				String proBrand=request.getParameter("proBrand");
				String MadeIN=request.getParameter("proMadeIn");
				
				Date mfgDate=Date.valueOf(request.getParameter("proMfgDate"));
				Date expDate=Date.valueOf(request.getParameter("proExpDate"));

				Part part=request.getPart("proImage");
				InputStream inputStream=part.getInputStream();
				//convertion of inputstream into bytearray[]
				byte[]proImage = IOUtils.toByteArray(inputStream);
				
				Part part1=request.getPart("proAudio");
				InputStream inputStream1=part1.getInputStream();
				//convertion of inputstream into bytearray[]
				byte[] proAudio= IOUtils.toByteArray(inputStream1);
				
				Part part2=request.getPart("proVideo");
				InputStream inputStream2=part2.getInputStream();
				//convertion of inputstream into bytearray[]
				byte[] proVideo= IOUtils.toByteArray(inputStream2);
				
				//using above details create the product object
				Product prodct=new Product();
				prodct.setProId(proId);
				prodct.setProName(proName);
				
				prodct.setProPrice(proPrice);
				prodct.setProBrand(proBrand);
				prodct.setProMadeIn(MadeIN);
				
				prodct.setProMfgDate(mfgDate);
				prodct.setProExpDate(expDate);
				prodct.setProImage(proImage);
				prodct.setProAudio(proAudio);
				prodct.setProVideo(proVideo);

				//giving the product object to DAO layer
				ProductDao productDao=new ProductDao();
				
				int result=productDao.save(prodct);
				
				if(result==1)
				{
					//to send the data to jsp file add the data into request object
					request.setAttribute("count", result);
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
					dispatcher.forward(request, response);
				}
				
				else
				{
					response.setContentType("text/html");
					PrintWriter writer1=response.getWriter();
					writer1.println("Data inserted fail check once..."+result);
					RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
					dispatcher.include(request, response);
				}
			
	}
}