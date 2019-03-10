package casestudy.homeinsurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import casestudy.homeinsurance.bo.UserBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.User;

/**
 * Servlet implementation class RegisterMe
 */
@WebServlet("/RegisterMe")
public class RegisterMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(username.equals(""))
		{
			request.setAttribute("message", "ENTER A USERNAME!");
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
		else if(password.equals("") || repassword.equals(""))
		{
			request.setAttribute("message", "ENTER PASSWORD TWICE!");
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
		
		else if(password.equals(repassword))
		{
			User myUser = new User(username, password);
			UserBO ubo = new UserBO();
			try {
				if(ubo.registerUser(myUser))
				{
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
				else
				{
					request.setAttribute("message", "USER ALREADY REGISTERED!");
					request.getRequestDispatcher("register.jsp").include(request, response); 
				}
			} catch (MyJDBCException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			request.setAttribute("message", "YOUR PASSWORDS DO NOT MATCH!");
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
	}
}
