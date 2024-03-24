package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		//read the data
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				//process the data
				String status;
//				if(username.equals("sathya")&&password.equals("sathya@123"))
//				{
//					status="Login successfull....";
//				}
//				else
//				{
//					status="login fail.....";
//				}
//				//render the response
//				PrintWriter writer=response.getWriter();
//				response.setContentType("text/html");
//				writer.println("<html>");
//				writer.println("<h1>Login status...</h1>"+status);
//				writer.println("</html>");
				
				//RequestDispathcer code
//				if(username.equals("sathya")&&password.equals("sathya@123"))
//				{
//					RequestDispatcher dispatcher=request.getRequestDispatcher("sucess.html");
//					dispatcher.forward(request, response);
//				}
//				else
//				{
//					response.setContentType("text/html");
//					PrintWriter writer=response.getWriter();
//					writer.println("Login fail check the creditials once...");
//					RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
//					dispatcher.include(request, response);
//				}
				
				//sendRedirect code
				
//				if(username.equals("sathya")&&password.equals("sathya@123"))
//				{
//					response.sendRedirect("http://www.tcs.com");
//				}
//				else
//				{
//					response.sendError(808,"login fail check the details once..");
//				}
				
				//Hyperlinks code
				
				
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					if(username.equals("sathya")&&password.equals("sathya@123"))
					{
						writer.println("login successful <br>");
						writer.println("<a href='http://www.sathya.com'>click here to open the sathya web page</a>");
					}
					else
					{
						writer.println("login successful <br>");
						writer.println("<a href='login.html'>click here open to login page</a>");

					}
				
				
				
				
	}

}
