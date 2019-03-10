package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Homeowner;
import casestudy.homeinsurance.model.User;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class HomeownerDAO {
	public Homeowner getHomeowner(final User user) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Homeowner Homeowner = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_HOMEOWNER_BY_USERID);
			stmt.setInt(1, user.getUserid());
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				Homeowner = new Homeowner(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
						resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7));
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
		return Homeowner;
	}
	
	public void registerHomeowner(final User user, final Homeowner homeowner) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_HOMEOWNER);
			stmt.setInt(1, user.getUserid());
			stmt.setString(2, homeowner.getFname());
			stmt.setString(3, homeowner.getLname());
			stmt.setString(4, homeowner.getDob());
			stmt.setInt(5, homeowner.getRetired());
			stmt.setString(6, homeowner.getSsn());
			stmt.setString(7, homeowner.getEmail());
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
	public void updateHomeownerDetails(final User user, final Homeowner homeowner) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.UPDATE_HOMEOWNER);
			stmt.setString(1, homeowner.getFname());
			stmt.setString(2, homeowner.getLname());
			stmt.setString(3, homeowner.getDob());
			stmt.setInt(4, homeowner.getRetired());
			stmt.setString(5, homeowner.getSsn());
			stmt.setString(6, homeowner.getEmail());
			stmt.setInt(7, user.getUserid());
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
				resultSet.close();
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
			}
		}
	}
	
	public boolean homeOwnerExist(final User user) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.CHECK_EXIST);
			stmt.setInt(1, user.getUserid());
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
	
	public static void main(String[] args) throws MyJDBCException {
//		stmt.setInt(1, user.getUserid());
//		stmt.setString(2, homeowner.getFname());
//		stmt.setString(3, homeowner.getLname());
//		stmt.setString(4, homeowner.getDob());
//		stmt.setInt(5, homeowner.getRetired());
//		stmt.setString(6, homeowner.getSsn());
//		stmt.setString(7, homeowner.getEmail());
		Homeowner ho = new Homeowner(14, "test1", "testLast1", "1990-01-01", 0, "123456789", "test@email.com");
		HomeownerDAO h_dao = new HomeownerDAO();
		User u = new User(500, "test1", "password1");
		h_dao.registerHomeowner(u, ho);
	}
}