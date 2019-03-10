package casestudy.homeinsurance.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.User;
import casestudy.homeinsurance.util.HomeInsuranceConstants;
import casestudy.homeinsurance.util.OracleSqlQueries;


public class UserDAO {
	public User getUser(final String userName) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		User user = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_USER_BY_USERNAME);
			stmt.setString(1, userName);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
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
		return user;
	}
	public User getUserById(final String userid) throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		User user = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.SELECT_USER_BY_USERID);
			stmt.setString(1, userid);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
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
		return user;
	}
	public void registerUser(final User user) throws MyJDBCException
	{
		System.out.println("Inside registerUser");
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
//			OracleConnection oc = new OracleConnection();
			conn = daoFactory.getConnection();
//			conn = oc.getConnection();
			System.out.println("registerUser connection made");
			stmt = conn.prepareStatement(OracleSqlQueries.REGISTER_USER);
			stmt.setInt(1, (this.getNumberOfUsers()+1));
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getUserpass());
			System.out.printf("Name: %s, Pass: %s\n", user.getUsername(), user.getUserpass());
			System.out.println("Statement: " + stmt.toString());
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Catch SQL Exception.");
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
					System.out.println("Inside stmt.close try");
					stmt.close();
					conn.close();
					System.out.println("After stmt.close try");
				
			}
			catch (SQLException e)
			{
				//trace your errors
			}
		}
	}
	public int getNumberOfUsers() throws MyJDBCException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int numberofusers=0;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.NUMBER_OF_USERS);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				numberofusers = resultSet.getInt(1);
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
		return numberofusers;
	}
	
	public static void main(String[] args) throws MyJDBCException {
		User u = new User("test1", "password1");
		UserDAO u_dao = new UserDAO();
		
		u_dao.registerUser(u);
	}
	
	//Test Helper -- JUnit
	public void deleteUserById(Integer userId) throws MyJDBCException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.ORACLE);
            conn = daoFactory.getConnection();
            String deleteString = "delete from userlist where userid = ?";
            stmt = conn.prepareStatement(deleteString);
            stmt.setInt(1, userId);
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
