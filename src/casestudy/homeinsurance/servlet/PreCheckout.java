package casestudy.homeinsurance.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreCheckout
 */
@WebServlet("/PreCheckout")
public class PreCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date start = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		String startStr = format1.format(start);
		String startPieces[] = startStr.split("/");
		//find year
		Integer year = Integer.parseInt(startPieces[2]);
		Integer year2 = year;
		Integer opyear = year;
		//find month 
		Integer month = Integer.parseInt(startPieces[0]);
		Integer month2 = month+2;
		Integer originalMonth2 = month2;
		String regex = "";
		for(int i = month; i<= originalMonth2; i++)
		{
			int myMonth = i;
			if(i>12)
			{
				myMonth-=12;
			}
			if(myMonth<10)
			{
				regex+="0";
			}
			regex+=myMonth+"/"+startPieces[1]+"/"+opyear;
			if(!(i==originalMonth2))
			{
				regex+="|";
			}
			if(i==12)
			{
				opyear++;
				year2++;
				month2-=12;
			}
		}
		String regexTitle = startStr + " to "; 
		if(month2 < 10)
		{
			regexTitle += "0";
		}			
		regexTitle += month2+"/"+startPieces[1]+"/"+year2 ;		
		request.setAttribute("regex", regex);
		request.setAttribute("regexTitle", regexTitle);
		request.getRequestDispatcher("checkout.jsp").include(request, response);
	}
}
