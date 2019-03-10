package casestudy.homeinsurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.HomeownerBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Homeowner;
import casestudy.homeinsurance.model.User;

/**
 * Servlet implementation class SetHomeowner
 */
@WebServlet("/SetHomeowner")
public class SetHomeowner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check if Homeowner exists
		HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
     
        Homeowner homeowner = new Homeowner(user.getUserid(), request.getParameter("fname"),
        		request.getParameter("lname"), request.getParameter("dob"),
        		Integer.parseInt(request.getParameter("retired")), request.getParameter("ssn"),
        		request.getParameter("email"));
        HomeownerBO hbo = new HomeownerBO();
        try {
			if(hbo.homeOwnerExist(user))
			{
				hbo.updateHomeownerDetails(user, homeowner);
			}
			else
			{
				hbo.registerHomeowner(user, homeowner);
			}
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
        session.setAttribute("homeowner", homeowner);
        request.getRequestDispatcher("propdeets.jsp").include(request, response);
	}
}
