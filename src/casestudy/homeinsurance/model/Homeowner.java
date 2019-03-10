package casestudy.homeinsurance.model;

public class Homeowner {
	private int userid;
	private String fname;
	private String lname;
	private String dob;
	private int retired; //0-no, 1-yes
	private String ssn;
	private String email;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getRetired() {
		return retired;
	}
	public void setRetired(int retired) {
		this.retired = retired;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Homeowner(int userid, String fname, String lname, String dob, int retired, String ssn, String email) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.retired = retired;
		this.ssn = ssn;
		this.email = email;
	}
	
}
