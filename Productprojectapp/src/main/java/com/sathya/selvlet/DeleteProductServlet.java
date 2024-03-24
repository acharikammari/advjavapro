package com.sathya.selvlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String proId=request.getParameter("proId");
		
		ProductDao productDao=new ProductDao();
		
		int Dresult=productDao.deleteById(proId);
		
		if(Dresult==1)
		{
			//to send the data to jsp file add the data into request object
			request.setAttribute("Dcount", Dresult);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.include(request, response);
			
		}
		else
		{
			//to send the data to jsp file add the data into request object
			request.setAttribute("Dcount", Dresult);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.include(request, response);
			
		}
	}
	

}