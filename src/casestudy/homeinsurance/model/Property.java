package casestudy.homeinsurance.model;

public class Property {
	private int locationid;
	private double mktval;
	private int yr;
	private double sqft;
	private String dwelling;
	private String roofmtl;
	private String garage;
	private int baths;
	private int halfbaths;
	private int pool;
	
	public Property(int locationid, double mktval, int yr, double sqft, String dwelling, String roofmtl, String garage,
			int baths, int halfbaths, int pool) {
		super();
		this.locationid = locationid;
		this.mktval = mktval;
		this.yr = yr;
		this.sqft = sqft;
		this.dwelling = dwelling;
		this.roofmtl = roofmtl;
		this.garage = garage;
		this.baths = baths;
		this.halfbaths = halfbaths;
		this.pool = pool;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public double getMktval() {
		return mktval;
	}
	public void setMktval(double mktval) {
		this.mktval = mktval;
	}
	public int getYr() {
		return yr;
	}
	public void setYr(int yr) {
		this.yr = yr;
	}
	public double getSqft() {
		return sqft;
	}
	public void setSqft(double sqft) {
		this.sqft = sqft;
	}
	public String getDwelling() {
		return dwelling;
	}
	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}
	public String getRoofmtl() {
		return roofmtl;
	}
	public void setRoofmtl(String roofmtl) {
		this.roofmtl = roofmtl;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public int getHalfbaths() {
		return halfbaths;
	}
	public void setHalfbaths(int halfbaths) {
		this.halfbaths = halfbaths;
	}
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
}
