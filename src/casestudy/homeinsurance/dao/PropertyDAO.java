package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.Property;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class PropertyDAO {
	public Property getProperty(final Location location) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Property property = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_PROPERTY_BY_LOCATIONID);
			stmt.setInt(1, location.getLocationid());
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				property = new Property(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10));
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
		return property;
	}
	
	public void registerProperty(final Location location, final Property property) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_PROPERTY);
//			stmt.setInt(1, location.getLocationid());
			stmt.setInt(1, property.getLocationid()+1);
			stmt.setDouble(2, property.getMktval());
			stmt.setInt(3, property.getYr());
			stmt.setDouble(4, property.getSqft());
			stmt.setString(5, property.getDwelling());
			stmt.setString(6, property.getRoofmtl());
			stmt.setString(7, property.getGarage());
			stmt.setInt(8, property.getBaths());
			stmt.setInt(9, property.getHalfbaths());
			stmt.setInt(10, property.getPool());
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
	public void updatePropertyDetails(final Location location, final Property property) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		@SuppressWarnings("unused")
		ResultSet resultSet = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.UPDATE_PROPERTY);
			
			stmt.setDouble(1, property.getMktval());
			stmt.setInt(2, property.getYr());
			stmt.setDouble(3, property.getSqft());
			stmt.setString(4, property.getDwelling());
			stmt.setString(5, property.getRoofmtl());
			stmt.setString(6, property.getGarage());
			stmt.setInt(7, property.getBaths());
			stmt.setInt(8, property.getHalfbaths());
			stmt.setInt(9, property.getPool());
			stmt.setInt(10, location.getLocationid());
			
			resultSet = stmt.executeQuery();

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
	public boolean propertyExist(final Location location) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.CHECK_PROP_EXIST);
			stmt.setInt(1, location.getLocationid());
			resultSet = stmt.executeQuery();
			if(resultSet.next())
			{
				if(resultSet.getInt(1)==1) return true;
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
		return false;
	}
}