package casestudy.homeinsurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.LocationBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.User;

/**
 * Servlet implementation class GetQuote
 */
@WebServlet("/GetQuote")
public class GetQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user"); 
        LocationBO lbo = new LocationBO();
        Location location = null;
        String restype = request.getParameter("restype");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String city = request.getParameter("city");
        String statename = request.getParameter("statename");
        String[] ziptemp = request.getParameter("zip").split("-");
        String resuse = request.getParameter("resuse");
        int zip = 0;
        if(ziptemp.length > 1)
        {
        	zip = 10000 * Integer.parseInt(ziptemp[0]);
        	zip += Integer.parseInt(ziptemp[1]);
        }
        else 
        {
        	zip = Integer.parseInt(ziptemp[0]);
        }
        try 
        {
        	System.out.println("Number of Location: " + lbo.getNumberOfLocations());
        	int locNum = lbo.getNumberOfLocations();
			location = new Location(locNum, user.getUserid(), restype, addr1, addr2, city, statename, zip, resuse);
			lbo.registerLocation(user, location);
			
		} 
        catch (MyJDBCException e) 
        {
			e.printStackTrace();
		}
        System.out.println("GetQuote:Location: " + location.getLocationid());
        session.setAttribute("location", location);
        System.out.println("Session:Location: " + session.getAttribute("location"));
        request.getRequestDispatcher("homeoinfo.jsp").include(request, response);
	}

}
