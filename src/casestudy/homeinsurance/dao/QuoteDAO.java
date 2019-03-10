package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Property;
import casestudy.homeinsurance.model.Quote;
import casestudy.homeinsurance.model.User;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class QuoteDAO {
	
	public List<Quote> getQuotes(User user) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List<Quote> quotes = new ArrayList<Quote>();
		Quote quote = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.RETRIEVE_QUOTES_FOR_USER);
			stmt.setInt(1, user.getUserid());
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				quote = new Quote(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3),
						resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
						resultSet.getDouble(7), resultSet.getDouble(8), resultSet.getDouble(9));
				quotes.add(quote);
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
		return quotes;
		
	}
	
	public Quote getQuote(final Property property) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Quote quote = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_QUOTE_BY_PROPERTY_LOCATIONID);
			stmt.setInt(1, property.getLocationid());
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				quote = new Quote(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8), resultSet.getDouble(9));
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
		return quote;
	}
	
	public void registerQuote(final Property property, final Quote quote) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_QUOTE);
			stmt.setInt(1, quote.getQuoteid());
			stmt.setInt(2, quote.getLocationid());
			stmt.setDouble(3, quote.getMnthlypremium());
			stmt.setDouble(4, quote.getDwellingcoverage());
			stmt.setDouble(5, quote.getDetachedstructure());
			stmt.setDouble(6, quote.getPersonalproperty());
			stmt.setDouble(7, quote.getAddllivingexpense());
			stmt.setDouble(8, quote.getMedicalexpense());
			stmt.setDouble(9, quote.getDeductible());
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
	public int getNumberOfQuotes() throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int numberofquotes=0;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.NUMBER_OF_QUOTES);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				numberofquotes = resultSet.getInt(1);
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
		return numberofquotes;
	}
}