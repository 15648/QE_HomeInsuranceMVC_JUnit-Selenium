package casestudy.homeinsurance.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.UserBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.User;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		UserBO ubo = new UserBO();
		User myUser = null;
		try {
			myUser = ubo.getUser(user);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
		if(myUser == null || pass.equals("")) {
			//user doesn't exist or no password entered
			request.setAttribute("message", "INCORRECT USERNAME/PASSWORD");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		else if(myUser.getUserpass().equals(pass)) 
		{
			//user and password are good
			HttpSession session=request.getSession();
	        session.setAttribute("user",myUser); 
	        request.getRequestDispatcher("getstarted.jsp").include(request, response);
		} else {
			//incorrect password
			request.setAttribute("message", "INCORRECT USERNAME/PASSWORD");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
	}

}
