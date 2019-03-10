package casestudy.homeinsurance.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import casestudy.homeinsurance.bo.PolicyBO;
import casestudy.homeinsurance.bo.UserBO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Policy;
import casestudy.homeinsurance.model.User;

@Controller
public class Admin {
	@RequestMapping(value= {"/adminlogin"}, method= RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView model = new ModelAndView("adminspring");
		return model;
	}
	@RequestMapping(value= {"/findadmin"}, method= RequestMethod.POST)
	public ModelAndView findUser(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		UserBO ubo = new UserBO();
		User user = null;
		ModelAndView model = null;
		try {
			 user = ubo.getUser(username);
		} catch (MyJDBCException e) {
			e.printStackTrace();
		}
		if(user==null || user.getRole() == null) {
			//failed to find user
			model = new ModelAndView("adminspring");
			model.addObject("message", "INCORRECT CREDENTIALS");
		}
		else if(user.getUsername().equals(username) && user.getUserpass().equals(password) && user.getRole().equals("ADMIN"))
		{
			//passed
			model = new ModelAndView("admincontrols");
		}
		else
		{
			//wrong password
			model = new ModelAndView("adminspring");
			model.addObject("message", "INCORRECT CREDENTIALS");
		}
		
		return model;
	}
	@RequestMapping(value= {"/finduser"}, method= RequestMethod.POST)
	public ModelAndView findUser(@RequestParam("username") String username)
	{
		
		UserBO ubo = new UserBO();
		PolicyBO pbo = new PolicyBO();
		User user = null;
		List<Policy> policies = new ArrayList<Policy>();
		ModelAndView model = new ModelAndView("admincontrols");
		try {
			user = ubo.getUser(username);
			policies = pbo.getPolicy(user);
		} catch (MyJDBCException | NullPointerException e) {
			model.addObject("message", "User does not exist");
			return model;
		}
		if(user!=null)
		{
			model = new ModelAndView("showuserpolicies");
			model.addObject("policies", policies);
		}
		return model;
	}
	@RequestMapping(value= {"/cancelorrenewpolicy"}, method= RequestMethod.GET)
	public ModelAndView cancelOrRenewPolicy(@RequestParam("userid") String userid, @RequestParam("policyid") String policyid, @RequestParam("action") String action) throws MyJDBCException
	{
		
		ModelAndView model = new ModelAndView("showuserpolicies");
		User user = null;
		
		PolicyBO pbo = new PolicyBO();
		UserBO ubo = new UserBO();
		
		pbo.updateStatus(policyid, action);
		
		user = ubo.getUserById(userid);
		
		List<Policy> policies = pbo.getPolicy(user);

		model.addObject("policies", policies);
		return model;
	}
	@RequestMapping(value= {"/logout"}, method= RequestMethod.GET)
	public ModelAndView logout()
	{
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	@RequestMapping(value= {"/admincontrols"}, method= RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("admincontrols");
		return model;
	}	
}
