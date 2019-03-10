package casestudy.homeinsurance.bo;

import java.util.List;

import casestudy.homeinsurance.dao.PolicyDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Policy;
import casestudy.homeinsurance.model.User;

public class PolicyBO {
	
	
	///change to get mulitiple policies like List<Policy> = new ArrayList<Policy>
	public List<Policy> getPolicy(final User	user) throws MyJDBCException{

		final PolicyDAO policyDAO = new PolicyDAO();
		List<Policy> policies = null;
		try
		{	
			policies = policyDAO.getPolicy(user);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return policies;
	}
	
	public void registerPolicy(final User user, final Policy policy) throws MyJDBCException{

		final PolicyDAO policyDAO = new PolicyDAO();
		try
		{
			policyDAO.registerPolicy(user, policy);	
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public int getNumberOfPolicys() throws MyJDBCException{
		final PolicyDAO PolicyDAO = new PolicyDAO();
		int numberofpolicies = 0;
		try
		{
			numberofpolicies = PolicyDAO.getNumberOfPolicies();
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return numberofpolicies;
	}
	public void updateStatus(String policyId, String status) throws MyJDBCException{
		
		final PolicyDAO policyDAO = new PolicyDAO();
		try
		{
			policyDAO.updateStatus(policyId, status);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
}
