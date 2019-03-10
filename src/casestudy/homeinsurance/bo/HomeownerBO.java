package casestudy.homeinsurance.bo;

import casestudy.homeinsurance.dao.HomeownerDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Homeowner;
import casestudy.homeinsurance.model.User;

public class HomeownerBO {
	public Homeowner getHomeowner(final User user) throws MyJDBCException
	{

		final HomeownerDAO homeownerDetails = new HomeownerDAO();
		Homeowner Homeowner = null;
		try
		{	
			Homeowner = homeownerDetails.getHomeowner(user);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return Homeowner;
	}
	
	public void registerHomeowner(final User user, final Homeowner homeowner) throws MyJDBCException
	{

		final HomeownerDAO homeownerDetails = new HomeownerDAO();
		try
		{
			homeownerDetails.registerHomeowner(user, homeowner);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public void updateHomeownerDetails(final User user, final Homeowner homeowner) throws MyJDBCException
	{
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		try
		{
			HomeownerDAO.updateHomeownerDetails(user, homeowner);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public boolean homeOwnerExist(final User user) throws MyJDBCException
	{
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		try
		{
			return HomeownerDAO.homeOwnerExist(user);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
}
