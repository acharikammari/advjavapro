package Com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")

public class Helloworldservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Helloworldservlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
	    writer.println("<html>");
		writer.println("<center><h1>welcome to sathya</h2>");
		writer.println("<h2>this is th first application</h2>");
		writer.println("<h3>welcome to ratan sir class</h3>");
		writer.println("</html>");
	}

	
	

}
