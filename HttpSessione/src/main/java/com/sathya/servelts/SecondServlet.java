package com.sathya.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SecondServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the client data
		
		String qualification=request.getParameter("qualification");
		String designation=request.getParameter("designation");
		
		//create the session object
		
		HttpSession session=request.getSession(false);
		
		//place the data into session object
		
		session.setAttribute("qualification",qualification );
		session.setAttribute("designation", designation);
		
		//give the next form to client
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
		dispatcher.forward(request, response);
	}

}
