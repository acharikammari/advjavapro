package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public RegistrationServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			//Step1:read the data
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			long mobile=Long.parseLong(request.getParameter("mobile"));
			String emali=request.getParameter("email");
			String gender=request.getParameter("gender");
			String dob=request.getParameter("dob");
			String[] quals=request.getParameterValues("qualification");
			String[] language= request.getParameterValues("language");
			String country=request.getParameter("country");
			String comments=request.getParameter("comments");
			
			//stpe2:process the data
			String q=String.join(",", quals);
			String l=String .join("-", language);
			
			//stpe3:process the data
			
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body bgcolor=pink>");
			writer.println("your username:"+name+"<br>");
			writer.println("your password:"+password+"<br>");
			writer.println("your mobile:"+mobile+"<br>");
			writer.println("your email:"+emali+"<br>");
			writer.println("your gender:"+gender+"<br>");
			writer.println("your date of birth:"+dob+"<br>");
			writer.println("your qualification:"+q+"<br>");
			writer.println("your language:"+l+"<br>");
			writer.println("your country:"+country+"<br>");
			writer.println("your comments:"+comments+"<br>");
			writer.println("</body>");
			writer.println("</html>");
			
	}
	

}
