package casestudy.homeinsurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.PolicyBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Policy;
import casestudy.homeinsurance.model.Quote;
import casestudy.homeinsurance.model.User;

/**
 * Servlet implementation class BuyPolicy
 */
@WebServlet("/BuyPolicy")
public class BuyPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PolicyBO pbo = new PolicyBO();
		
		User user = (User) session.getAttribute("user");
		Quote quote = (Quote) session.getAttribute("quote");	
		
		Policy policy = null;
		
		try {
			String startDate = request.getParameter("startDate");
			String temp[] = startDate.split("/");
			Integer year = Integer.parseInt(temp[2]);
			year++;
			String endDate = temp[0]+"/"+temp[1]+"/"+year.toString();
			policy = new Policy(pbo.getNumberOfPolicys()+1, user.getUserid(), quote.getQuoteid(),
					startDate, endDate, 1, "ACTIVE");
		} catch (MyJDBCException e1) {
			e1.printStackTrace();
		}
		
		try {
			pbo.registerPolicy(user, policy);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
		session.setAttribute("policy", policy);
		request.getRequestDispatcher("confirmation.jsp").include(request, response);
	}

}
