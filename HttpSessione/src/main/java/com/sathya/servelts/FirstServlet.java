package com.sathya.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
    	
    }
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//get the client data
		
		String username=request.getParameter("username");
		int age=Integer.parseInt(request.getParameter("age"));
		
		//create the session object
		
		HttpSession session=request.getSession();
		
		//place the data into session object
		
		session.setAttribute("username", username);
		session.setAttribute("age", age);
		
		//Give the nextform to client
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
		dispatcher.forward(request, response);
	}

}
