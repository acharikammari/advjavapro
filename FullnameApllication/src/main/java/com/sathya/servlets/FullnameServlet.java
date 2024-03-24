package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullnameServlet")
public class FullnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public FullnameServlet() {
        
    }

	
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//read the data
	   			String Firstname=request.getParameter("Firstname");
				String Middlename=request.getParameter("Middlename");
				String Lastname=request.getParameter("lastname");
				
				//process the data
				
				String s=Firstname+"    "+Middlename+"    "+Lastname;
				
				//render the response
				PrintWriter writer=response.getWriter();
				response.setContentType("text/html");
				writer.println("<html>");
				writer.println("<h1>FullName....</h1>"+"FullName:"+s);
				writer.println("</html>");
				
	
	}

	
	

}
