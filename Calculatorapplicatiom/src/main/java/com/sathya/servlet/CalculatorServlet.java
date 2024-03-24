package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CalculatorServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//read the data
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("secone"));
		String operation=request.getParameter("operation");
		
		//process the data
		
		int result=0;
		switch(operation)
		{
		case "+":result=num1+num2;
					break;
		case "-":result=num1-num2;
					break;
		case "*":result=num1*num2;
					break;
		case "/":result=num1/num2;
					break;
		case "%":result=num1%num2;
					break;			
		}
		//render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h1>Calculator</h1>");
		writer.println("<br><br>");
		writer.println("your fist number:"+num1);
		writer.println("<br><br>");
		writer.println("your second number:"+num2);
		writer.println("<br><br>");
		writer.println("operation symbol:"+operation);
		writer.println("<br><br>");
		writer.println("your result:"+result);
		writer.println("<br><br>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}

	
	

}
