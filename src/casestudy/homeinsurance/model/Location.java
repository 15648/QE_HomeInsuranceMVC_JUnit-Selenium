package casestudy.homeinsurance.model;

public class Location {
	private int locationid;
	private int userid;
	private String  restype;
	private String addr1;
	private String addr2;
	private String city;
	private String statename;
	private int zip;
	private String resuse;
	
	public Location(int locationid, int userid, String restype, String addr1, String addr2, String city,
			String statename, int zip, String resuse) {
		super();
		this.locationid = locationid;
		this.userid = userid;
		this.restype = restype;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.statename = statename;
		this.zip = zip;
		this.resuse = resuse;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRestype() {
		return restype;
	}
	public void setRestype(String restype) {
		this.restype = restype;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getResuse() {
		return resuse;
	}
	public void setResuse(String resuse) {
		this.resuse = resuse;
	}
}
