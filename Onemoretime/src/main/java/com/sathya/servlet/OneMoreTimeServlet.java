package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneMoreTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public OneMoreTimeServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			PrintWriter writer=response.getWriter();
			writer.println("welcome to hyd");
			writer.println("welcome to full stack java course");
			writer.println("welcome to adv java class");
			
	}
	

	
	


}
