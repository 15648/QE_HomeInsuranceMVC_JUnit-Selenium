package casestudy.homeinsurance.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
	    {  
	                response.setContentType("text/html");  
	                PrintWriter out=response.getWriter();  
	                out.print("<div id='header'>");  
	                request.getRequestDispatcher("header.html").include(request, response);  
	                out.print("</div>");  
	                HttpSession session=request.getSession();  
	                session.invalidate(); 	
	                out.print("<h1 style='text-align: center;'>You are successfully logged out!</h1>");
	                out.print("<h2>Log back in <a href='index.jsp'>here</a></h2>");
	                out.print("<div id='footer'>");
	                request.getRequestDispatcher("footer.html").include(request, response);
	                out.print("</div>");
	                out.close();  
	    }    
}

