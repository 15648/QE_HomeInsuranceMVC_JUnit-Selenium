package casestudy.homeinsurance.model;

public class Quote {
	private int quoteid;
	private int locationid;
	private double mnthlypremium;
	private double dwellingcoverage;
	private double detachedstructure;
	private double personalproperty;
	private double addllivingexpense;
	private double medicalexpense;
	private double deductible;
	
	
	public Quote(int quoteid, int locationid, double mnthlypremium, double dwellingcoverage, double detachedstructure,
			double personalproperty, double addllivingexpense, double medicalexpense, double deductible) {
		super();
		this.quoteid = quoteid;
		this.locationid = locationid;
		this.mnthlypremium = mnthlypremium;
		this.dwellingcoverage = dwellingcoverage;
		this.detachedstructure = detachedstructure;
		this.personalproperty = personalproperty;
		this.addllivingexpense = addllivingexpense;
		this.medicalexpense = medicalexpense;
		this.deductible = deductible;
	}
	public int getQuoteid() {
		return quoteid;
	}
	public void setQuoteid(int quoteid) {
		this.quoteid = quoteid;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public double getMnthlypremium() {
		return mnthlypremium;
	}
	public void setMnthlypremium(double mnthlypremium) {
		this.mnthlypremium = mnthlypremium;
	}
	public double getDwellingcoverage() {
		return dwellingcoverage;
	}
	public void setDwellingcoverage(double dwellingcoverage) {
		this.dwellingcoverage = dwellingcoverage;
	}
	public double getDetachedstructure() {
		return detachedstructure;
	}
	public void setDetachedstructure(double detachedstructure) {
		this.detachedstructure = detachedstructure;
	}
	public double getPersonalproperty() {
		return personalproperty;
	}
	public void setPersonalproperty(double personalproperty) {
		this.personalproperty = personalproperty;
	}
	public double getAddllivingexpense() {
		return addllivingexpense;
	}
	public void setAddllivingexpense(double addllivingexpense) {
		this.addllivingexpense = addllivingexpense;
	}
	public double getMedicalexpense() {
		return medicalexpense;
	}
	public void setMedicalexpense(double medicalexpense) {
		this.medicalexpense = medicalexpense;
	}
	public double getDeductible() {
		return deductible;
	}
	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}
}
