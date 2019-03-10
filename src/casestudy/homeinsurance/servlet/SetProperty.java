package casestudy.homeinsurance.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy.homeinsurance.bo.PropertyBO;
import casestudy.homeinsurance.bo.QuoteBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.Property;
import casestudy.homeinsurance.model.Quote;

/**
 * Servlet implementation class test
 */
@WebServlet("/SetProperty")
public class SetProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
        Location location = (Location) session.getAttribute("location");
        
        location.getLocationid();

        DecimalFormat format = new DecimalFormat("#.00");
        Property property = new Property(location.getLocationid(), Double.parseDouble(format.format(Double.parseDouble(request.getParameter("mktval")))), 
        		Integer.parseInt(request.getParameter("yr")), Double.parseDouble(format.format(Double.parseDouble(request.getParameter("sqft")))), 
        		request.getParameter("dwelling"), request.getParameter("roofmtl"), request.getParameter("garage"), 
        		Integer.parseInt(request.getParameter("baths")), Integer.parseInt(request.getParameter("halfbaths")),
        		Integer.parseInt(request.getParameter("pool")));
        
        PropertyBO pbo = new PropertyBO();
        try {
			if(pbo.propertyExist(location))
			{
				pbo.updatePropertyDetails(location, property);
			}
			else
			{
				System.out.println("Location ID: " + location.getLocationid());
				pbo.registerProperty(location, property);
			}
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
        QuoteBO qbo = new QuoteBO();
        //quote calculations
        int quoteid = 1;
        int locationid = -1;
        double mktval = Double.parseDouble(request.getParameter("mktval"));
        double calcval = mktval;
        double mnthlypremium = 5 * (mktval/1000);
        String restype = location.getRestype();
        if(restype.equals("Single-Family Home"))
        {
        	mnthlypremium *= 1.05;
        }
        else if(restype.equals("Condo") || restype.equals("Duplex") || restype.equals("Apartment"))
        {
        	mnthlypremium *= 1.06;
        }
        else
        {
        	mnthlypremium *= 1.07;
        }
        mnthlypremium /= 12;
        
        int yr = property.getYr();
        final int YEAR = 2017;
        double homeValue = 120 * Double.parseDouble(request.getParameter("sqft"));
        if(YEAR - yr < 5)
        {
//        	calcval*=0.9;
        	homeValue*=0.9;
        }
        else if(YEAR - yr < 10)
        {
//        	calcval*=0.8;
        	homeValue*=0.8;
        }
        else if(YEAR - yr < 20)
        {
//        	calcval*=0.7;
        	homeValue*=0.7;
        }
        else
        {
//        	calcval*=0.5;
        	homeValue*=0.5;
        }
//        double dwellingcoverage = 120 * Double.parseDouble(request.getParameter("sqft"));
        
//        dwellingcoverage += ((mktval*0.5)+calcval);
        
        double dwellingcoverage = (mktval * .5) + homeValue;
        
        double detachedstructure = 0.1*dwellingcoverage;
        double personalproperty = 0.6*dwellingcoverage;
        double addllivingexpense = 0.2*dwellingcoverage;
        double medicalexpense = 5000;
        double deductible = mktval * 0.01;
		try {
			quoteid =  qbo.getNumberOfQuotes()+1;
			// Modified code 190212 @ 5:07
			// location.getLocationid();
			locationid = location.getLocationid();
			locationid++;
		} catch (MyJDBCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        //store a quote
		
		Quote quote =new Quote(quoteid, locationid, Double.parseDouble(format.format(mnthlypremium)), Double.parseDouble(format.format(dwellingcoverage)), Double.parseDouble(format.format(detachedstructure)), Double.parseDouble(format.format(personalproperty)), Double.parseDouble(format.format(addllivingexpense)), Double.parseDouble(format.format(medicalexpense)), Double.parseDouble(format.format(deductible)));
		try {
			qbo.registerQuote(property, quote);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
        session.setAttribute("quote", quote);
        session.setAttribute("property", property);
        //send to a page with the quote so they can purchase
        request.getRequestDispatcher("coveragedetails.jsp").include(request, response);
	}
}
