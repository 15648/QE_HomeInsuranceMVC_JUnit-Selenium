package casestudy.homeinsurance.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.QuoteBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Quote;
import casestudy.homeinsurance.model.User;

@WebServlet("/RetrieveQuote")
public class RetrieveQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		QuoteBO qbo = new QuoteBO();
		List<Quote> quotes = null;
		try {
			quotes = qbo.getQuotes(user);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
		request.setAttribute("quotes", quotes.size());
		for(int i = 0; i < quotes.size(); i++)
		{
			request.setAttribute("quote_"+i+"_quoteid", quotes.get(i).getQuoteid());
			request.setAttribute("quote_"+i+"_locationid", quotes.get(i).getLocationid());
			request.setAttribute("quote_"+i+"_mnthlypremium", quotes.get(i).getMnthlypremium());
			request.setAttribute("quote_"+i+"_dwellingcoverage", quotes.get(i).getDwellingcoverage());
			request.setAttribute("quote_"+i+"_detachedstructure", quotes.get(i).getDetachedstructure());
			request.setAttribute("quote_"+i+"_personalproperty", quotes.get(i).getPersonalproperty());
			request.setAttribute("quote_"+i+"_addllivingexpense", quotes.get(i).getAddllivingexpense());
			request.setAttribute("quote_"+i+"_medicalexpense", quotes.get(i).getMedicalexpense());
			request.setAttribute("quote_"+i+"_deductible", quotes.get(i).getDeductible());
		}
		request.getRequestDispatcher("retrievequote.jsp").include(request, response);		
	}
}
