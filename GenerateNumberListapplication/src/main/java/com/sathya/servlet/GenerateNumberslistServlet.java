package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GenerateNumberslistServlet")
public class GenerateNumberslistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private char[] i;

    
    public GenerateNumberslistServlet() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//read the data
		int first=Integer.parseInt(request.getParameter("first"));
		int end=Integer.parseInt(request.getParameter("end"));
		String operation=request.getParameter("operation");
		
		//process the data
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("yor start numbe:"+first);
		writer.println("<br><br>");
		writer.println("yor start numbe:"+end);
		writer.println("<br><br>");
		int count=0;
		switch(operation)
		{
			case "Even":for(int i=first;i<=end;i++)
							{
								if(i%2==0)
								{
									writer.println(i);
								}
								
								
							}
							break;
			case "odd":for(int i=first;i<=end;i++)
						{
							if(i%2!=0)
							{
								writer.println(i);
							}
							
						}
						break;
			case "prime":for (int i = first; i <= end; i++) {
		        			count = 0; 
		        				for (int j = 1; j <= i; j++) {
		        					if (i % j == 0) {
		        						count++;
		        						}
		        				}
		        				if (count == 2) {
		        					writer.println(i);
		        				}
							}
							break;
			case "perfect":int i,j,sum=0;
							for(i=first;i<=end;i++)
							{
									sum=0;
								for(j=1;j<i;j++)
								{
									if(i%j==0)
									{
										sum=sum+j;
									}
								}
								if(sum==i)
								{
									writer.println(i);								}
							}
			case "Strong":  int rem, fact;
		    				for (int i1 = first; i1 <= end; i1++) 
		    				{
		    					int num = i1;
		    					sum = 0;
		    					while (num > 0) 
		    					{
		    						rem = num % 10;
		    						fact = 1;
		    						for (int j1 = 1; j1 <= rem; j1++) 
		    						{
		    							fact = fact * j1;
		    						}
		    						sum = sum + fact;
		    						num = num / 10;
		    					}
		    					if (sum == i1) 
		    					{
		    						writer.println(i1);
		    					}
		    				}
			
		}
		writer.println("</body>");
		writer.println("</html>");
		
	}

	
	

}
