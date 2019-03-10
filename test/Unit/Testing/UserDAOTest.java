package Unit.Testing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import Helper.Testing.TestHelper;
import casestudy.homeinsurance.dao.UserDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.User;

public class UserDAOTest {

	@Test
	public void loginUserTest() throws MyJDBCException {
		UserDAO u_dao = new UserDAO();
		User u = u_dao.getUser("testUser");
		
		System.out.println(u.getUserpass());
		assertThat("testPassword", equalTo(u.getUserpass()));
	}
	
	
	@Test()
	public void registerUserTest() throws MyJDBCException {
		UserDAO u_dao = new UserDAO();
		User u = new User("registerUser2", "registerPassword2");
//		user.setUsername("TestUser");
//		user.setUserpass("TestPassword");
		u_dao.registerUser(u);
		User u2 = u_dao.getUser(u.getUsername());
		assertThat(u.getUserpass(), equalTo(u2.getUserpass()));
		u_dao.deleteUserById(u2.getUserid());
	}
	
//	@Test()
//	public void deleteRecordHelper() throws MyJDBCException {
//		TestHelper deleteUserRecord = new TestHelper();
//	}
	
}
