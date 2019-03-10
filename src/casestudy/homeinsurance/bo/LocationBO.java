package casestudy.homeinsurance.bo;

import java.util.ArrayList;
import java.util.List;

import casestudy.homeinsurance.dao.LocationDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.User;

public class LocationBO {
	public List<Location> getLocation(final User user) throws MyJDBCException{

		final LocationDAO locationDAO = new LocationDAO();
		List<Location> locationlist = new ArrayList<Location>();
		try
		{	
			locationlist = locationDAO.getLocation(user);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return locationlist;
	}
	
	public void registerLocation(final User user, final Location location) throws MyJDBCException{

		final LocationDAO locationDAO = new LocationDAO();
		try
		{
			locationDAO.registerLocation(user, location);	
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public int getNumberOfLocations() throws MyJDBCException{
		final LocationDAO LocationDAO = new LocationDAO();
		int numberoflocations = 0;
		try
		{
			numberoflocations = LocationDAO.getNumberOfLocations();
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return numberoflocations;
	}
}
