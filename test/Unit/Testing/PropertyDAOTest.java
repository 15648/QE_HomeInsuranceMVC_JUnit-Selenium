package Unit.Testing;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import casestudy.homeinsurance.dao.PropertyDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Location;
import casestudy.homeinsurance.model.Property;
import Helper.Testing.*;

public class PropertyDAOTest {
	//Declare Attributes
	private static PropertyDAO p_dao;
	private static Property property;
	private static Location location;
	private double mktval, sqft;
	private int locationid, yr, baths, halfbaths, pool, userid, zip;
	private String dwelling, roofmtl, garage, restype, addr1, addr2, city, statename, resuse;
		
	@Test
	public void registerPropertyTest(Location location, Property property) throws MyJDBCException {
		property = new Property(locationid, mktval, yr, sqft, dwelling, roofmtl, garage,
				baths, halfbaths, pool);
		p_dao.registerProperty(location, property);
		
		List<Property> properties = (List<Property>) p_dao.getProperty(location);
		Assert.assertEquals(property.getLocationid(), properties.get(0).getLocationid());
	}
	
	@Test()
	public void deleteRecordHelper() throws MyJDBCException {
		TestHelper deletePropertyRecord = new TestHelper();
	}

}
