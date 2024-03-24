package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ThirdServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//display the total details
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<pre style='color:yellow'>");
		writer.println("username:"+cookies[0].getValue());
		writer.println("age:"+cookies[1].getValue());
		writer.println("qualification:"+cookies[2].getValue());
		writer.println("designation:"+cookies[3].getValue());
		writer.println("emali:"+request.getParameter("email"));
		writer.println("mobile:"+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
