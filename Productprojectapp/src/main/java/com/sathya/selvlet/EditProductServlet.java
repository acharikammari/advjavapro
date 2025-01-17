package com.sathya.selvlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String proId=request.getParameter("proId");
		
		ProductDao productDao=new ProductDao();
		
		Product existingproduct=productDao.findById(proId);

		//send the form to edit-from.jsp
		
		request.setAttribute("existingproduct", existingproduct);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Edit-form.jsp");
		dispatcher.forward(request, response);
	}
}