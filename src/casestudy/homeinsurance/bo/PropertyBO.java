package casestudy.homeinsurance.bo;

import casestudy.homeinsurance.dao.PropertyDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.Property;

public class PropertyBO {
	public Property getProperty(final Location location) throws MyJDBCException
	{

		final PropertyDAO propertyDetails = new PropertyDAO();
		Property property = null;
		try
		{	
			property = propertyDetails.getProperty(location);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return property;
	}
	
	public void registerProperty(final Location location, final Property property) throws MyJDBCException
	{

		final PropertyDAO propertyDetails = new PropertyDAO();
		try
		{
			propertyDetails.registerProperty(location, property);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public void updatePropertyDetails(final Location location, final Property property) throws MyJDBCException
	{
		final PropertyDAO propertyDAO = new PropertyDAO();
		try
		{
			propertyDAO.updatePropertyDetails(location, property);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public boolean propertyExist(final Location location) throws MyJDBCException
	{
		final PropertyDAO propertyDAO = new PropertyDAO();
		try
		{
			return propertyDAO.propertyExist(location);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
}