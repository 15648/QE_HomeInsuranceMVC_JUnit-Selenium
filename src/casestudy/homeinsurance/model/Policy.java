package casestudy.homeinsurance.model;

public class Policy {
	private int policyid;
	private int userid;
	private int quoteid;
	private String effectiveDate;
	private String endDate;
	private int term;
	private String status;
	public Policy( int policyid, int userid, int quoteid, String effectiveDate, String endDate, int term, String status) {
		super();
		this.policyid = policyid;
		this.userid = userid;
		this.quoteid = quoteid;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.term = term;
		this.setStatus(status);
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPolicyid() {
		return policyid;
	}
	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}
	public int getQuoteid() {
		return quoteid;
	}
	public void setQuoteid(int quoteid) {
		this.quoteid = quoteid;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
