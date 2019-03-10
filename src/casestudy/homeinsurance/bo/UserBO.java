package casestudy.homeinsurance.bo;

import casestudy.homeinsurance.dao.UserDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.User;

public class UserBO {
	public User getUser(final String userName) throws MyJDBCException{

		final UserDAO loginDAO = new UserDAO();
		User user = null;
		try
		{	
			user = loginDAO.getUser(userName);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return user;
	}
	
	public boolean registerUser(final User user) throws MyJDBCException{

		final UserDAO UserDAO = new UserDAO();
		try
		{
			UserDAO.registerUser(user);	
		}
		catch(MyJDBCException e)
		{
			return false;
		}
		return true;
	}
	public int getNumberOfUsers() throws MyJDBCException{
		final UserDAO UserDAO = new UserDAO();
		int numberofusers = 0;
		try
		{
			numberofusers = UserDAO.getNumberOfUsers();
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return numberofusers;
	}
	public User getUserById(final String userid) throws MyJDBCException
	{
		final UserDAO UserDao = new UserDAO();
		User user = null;
		try
		{
			user = UserDao.getUserById(userid);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return user;
	}
}
