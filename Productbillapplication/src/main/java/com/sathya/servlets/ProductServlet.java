package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//step1 read the data
		int proid=Integer.parseInt(request.getParameter("proID"));
		String proname=request.getParameter("proName");
		int proprice=Integer.parseInt(request.getParameter("proPrice"));
		double proquantity=Double.parseDouble(request.getParameter("proQuantity"));
		
		//process the data
		double tb=proprice*proquantity ;
		double dis=0.0;
		
		if(tb<1000)
		{
			dis=tb*1;
			
		}
		else if(tb<5000 && tb>1000)		
		{
			dis=tb*0.05;
			
		}
		else if(tb>5000 &&tb >10000)
		{
			dis=tb*0.1;
		}
		else
		{
			tb=tb*0.15;
		}
		double Netbill=(tb-dis);
		//render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<h1>product Bill calculation....</h1>");
		writer.println("<body bgcolor=pink>");
		writer.println("<br><br>");
		writer.println(" productid:"+proid);
		writer.println("<br>");
		writer.println("productname:"+proname);
		writer.println("<br>");
		writer.println("product price:"+proprice);
		writer.println("<br>");
		writer.println(" product quantity:"+proquantity);
		writer.println("<br>");
		writer.println(" total bill amount:$"+tb);
		writer.println("<br>");
		writer.println("discount amount:$"+dis);
		writer.println("<br>");
		writer.println("Netamount to pay:$"+Netbill);
		writer.println("<br>");
		writer.println("</html>");
	}


}
