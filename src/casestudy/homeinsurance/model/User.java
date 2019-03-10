package casestudy.homeinsurance.model;

public class User {
	private int userid;
	private String username;
	private String userpass;
	private String role;
//	private List<Property> properties;
//	private List<Policy> policies;
//	private List<Quote> quotes;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public User(String username, String userpass) {
		this.username = username;
		this.userpass = userpass;
	}
	public User(int userid, String username, String userpass) {
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
	}
	public User(int userid, String username, String userpass, String role) {
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}