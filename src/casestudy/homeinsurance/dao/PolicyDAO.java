package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Policy;
import casestudy.homeinsurance.model.User;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class PolicyDAO {
	public List<Policy> getPolicy(final User user) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List<Policy> policies = new ArrayList<Policy>();
		Policy policy = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_POLICY_BY_USERID);
			stmt.setInt(1, user.getUserid());
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				policy = new Policy(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
				policies.add(policy);
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
		return policies;
	}
	
	public void registerPolicy(final User user, final Policy policy) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_POLICY);
			stmt.setInt(1, policy.getPolicyid());
			stmt.setInt(2, policy.getUserid());
			stmt.setInt(3, policy.getQuoteid());
			stmt.setString(4, policy.getEffectiveDate());
			stmt.setString(5, policy.getEndDate());
			stmt.setInt(6, policy.getTerm());
			stmt.setString(7, policy.getStatus());
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
	public int getNumberOfPolicies() throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int numberofpolicies=0;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.NUMBER_OF_POLICIES);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				numberofpolicies = resultSet.getInt(1);
			}
			stmt.close();
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
		return numberofpolicies;
	}
	public void updateStatus(String policyId, String status) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.UPDATE_POLICY_STATUS);
			stmt.setString(1, status);
			stmt.setString(2, policyId);
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
}