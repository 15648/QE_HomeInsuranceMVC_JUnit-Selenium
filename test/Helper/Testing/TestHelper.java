package Helper.Testing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.*;

public class TestHelper
{
    public static void deleteRecordHelper(String query, int idToDelete) throws MyJDBCException {
    	
    	Homeowner homeowner = null;
    	String deleteHomeownerRecord = "delete * from homeowner where userid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteHomeownerRecord);
    		    System.out.println("Record deleted successfully");
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		}	
    	
    	Location location = null;
    	String deleteLocationRecord = "delete * from location where userid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteLocationRecord );
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		}  
    	
    	Policy policy = null;
    	String deletePolicyRecord = "delete * from policy where userid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deletePolicyRecord );
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		} 
    	Property property = null;
    	String deletePropertyRecord = "delete * from property where locationid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deletePropertyRecord );
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		} 
    	
    	Quote quote = null;
    	String deleteQuoteRecord = "delete * from quote where quoteid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteQuoteRecord );
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		} 
    	
    	User user = null;
    	String deleteUserRecord = "delete * from userlist where userid= ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"HOMEINSURANCE", "HOMEINSURANCE");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteUserRecord );
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		}  
    }

}
