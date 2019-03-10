package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.User;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class LocationDAO {
	public List<Location> getLocation(final User user) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Location location = null;
		List<Location> locations = new ArrayList<Location>();
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_LOCATION_BY_USERID);
			stmt.setInt(1, user.getUserid());
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				location = new Location(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), 
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 
						resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9));
				locations.add(location);
			}
		}
		catch (SQLException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new MyJDBCException(e.getMessage());
		} 
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
			}
		}
		return locations;
	}
	
	public void registerLocation(final User user, final Location location) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_LOCATION);
			stmt.setInt(1, location.getLocationid()+1);
//			stmt.setInt(1, location.getLocationid());
			stmt.setInt(2, user.getUserid());
			stmt.setString(3, location.getRestype());
			stmt.setString(4, location.getAddr1());
			stmt.setString(5, location.getAddr2());
			stmt.setString(6, location.getCity());
			stmt.setString(7, location.getStatename());
			stmt.setInt(8, location.getZip());
			stmt.setString(9, location.getResuse());
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new MyJDBCException(e.getMessage());
		} 
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				
			}
		}
	}
	public int getNumberOfLocations() throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int numberoflocations=0;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.NUMBER_OF_LOCATIONS);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				numberoflocations = resultSet.getInt(1);
			}
		}
		catch (SQLException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new MyJDBCException(e.getMessage());
		} 
		finally
		{
			try
			{
				resultSet.close();
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
			}
		}
		return numberoflocations;
	}
}