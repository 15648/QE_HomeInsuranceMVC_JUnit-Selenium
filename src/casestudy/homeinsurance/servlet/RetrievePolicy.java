package casestudy.homeinsurance.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.PolicyBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Policy;
import casestudy.homeinsurance.model.User;

@WebServlet("/RetrievePolicy")
public class RetrievePolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		PolicyBO pbo = new PolicyBO();
		List<Policy> policies = null;
		try {
			policies = pbo.getPolicy(user);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
		request.setAttribute("policies", policies.size());
		for(int i = 0; i < policies.size(); i++)
		{
			request.setAttribute("policy_"+i+"_policyid", policies.get(i).getPolicyid());
			request.setAttribute("policy_"+i+"_userid", policies.get(i).getUserid());
			request.setAttribute("policy_"+i+"_quoteid", policies.get(i).getQuoteid());
			request.setAttribute("policy_"+i+"_effectivedate", policies.get(i).getEffectiveDate());
			request.setAttribute("policy_"+i+"_enddate", policies.get(i).getEndDate());
			request.setAttribute("policy_"+i+"_term", policies.get(i).getTerm());
			request.setAttribute("policy_"+i+"_status", policies.get(i).getStatus());
		}
		request.getRequestDispatcher("retrievepolicy.jsp").include(request, response);		
	}
}
