package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public EmployeeServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//read the data
				int empid=Integer.parseInt(request.getParameter("EmployeeID"));
				String empname=request.getParameter("employeename");
				int basicsalary=Integer.parseInt(request.getParameter("Basicsalary"));
				int hra,da,pf,gross_salary;
				if(basicsalary>=50000)
				{
					hra=(30*basicsalary)/100;
					da=(10*basicsalary)/100;
					pf=(6*basicsalary)/100;
					//gross_salary=basicsalary+hra+da-pf;
				}
				else if(basicsalary<50000 && basicsalary>25000)
				{
					hra=(20*basicsalary)/100;
					da=(5*basicsalary)/100;
					pf=(3*basicsalary)/100;
					//gross_salary=basicsalary+hra+da-pf;
				}
				else
				{
					hra=(10*basicsalary)/100;
					da=(3*basicsalary)/100;
					pf=(2*basicsalary)/100;
					//gross_salary=basicsalary+hra+da-pf;
				}
				gross_salary=basicsalary+hra+da-pf;
				//render the response
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter(); 
				writer.println("<html>");
				writer.println("<h1> employee info....</h1>");
				writer.println("<br><br>");
				writer.println("<body bgcolor=pink>");
				writer.println("employee id;"+empid);
				writer.println("<br>");
				writer.println("employeename:"+empname);
				writer.println("<br>");
				writer.println("employee basic_salary:"+basicsalary);
				writer.println("<br>");
				writer.println("HRA ammount:"+hra);
				writer.println("<br>");
				writer.println("DA amount:"+da);
				writer.println("<br>");
				writer.println("PF amount:"+pf);
				writer.println("<br>");
				writer.println("gross salary:"+gross_salary);
				writer.println("</html>");
	}	
}


