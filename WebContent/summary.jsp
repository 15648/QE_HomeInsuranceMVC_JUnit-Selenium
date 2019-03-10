<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Quote Summary</title>
<%@page import="casestudy.homeinsurance.model.Location" %>
<%@page import="casestudy.homeinsurance.model.Quote" %>
<%@page import="casestudy.homeinsurance.model.Property" %>
<%@page import="casestudy.homeinsurance.model.Homeowner" %>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.text.DecimalFormat" %>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<% 	Location location = (Location) session.getAttribute("location");
		Quote quote = (Quote) session.getAttribute("quote");
		Property property = (Property) session.getAttribute("property");
		Homeowner homeowner = (Homeowner) session.getAttribute("homeowner");
		NumberFormat formatter = new DecimalFormat("#0.00");   
	%>
	<div class="center">
		<h2>Quote Summary</h2>
		<br/><br/>
		<h1>Monthly Premium <span style="color: red;">$</span><%= formatter.format(quote.getMnthlypremium()) %></h1>
		<br/><br/>
		<form action="PreCheckout" method="get">
			<button type="submit" value="Buy Quote">Buy Quote</button>
			<table style="width: 800px;">
				<tr>
					<td>
						<table>
							<tr>
								<td colspan="2" style="font-weight: bold;">Location Details<br/></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Quote Id</td><td><%=  quote.getQuoteid() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Residence Type</td><td><%= location.getRestype() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Address Line 1</td><td><%= location.getAddr1() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Address Line 2</td><td><%= location.getAddr2() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">City</td><td><%= location.getCity() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">State</td><td><%= location.getStatename() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Zip</td><td><%= location.getZip() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Residence Use</td><td><%= location.getResuse() %></td>
							</tr>
							<tr>
								<td colspan="2"><hr/></td>
							</tr>
						</table>
					</td>	
					<td>
						<table>
							<tr>
								<td colspan="2" style="font-weight: bold;">Homeowner Details<br/></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">First Name</td><td><%= homeowner.getFname() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Last Name</td><td><%= homeowner.getLname() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Date of Birth</td><td><%= homeowner.getDob() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Is Retired?</td><td><%= homeowner.getRetired()==1 ? "Yes" : "No" %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Social Security Number</td><td><%= homeowner.getSsn() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Email Address</td><td><%= homeowner.getEmail() %></td>
							</tr>
							<tr>
								<td colspan="2"><hr/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td colspan="2" style="font-weight: bold;">Property Details<br/></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Market Value</td><td>$<%= formatter.format(property.getMktval()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Year Built</td><td><%= property.getYr() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Square Footage</td><td><%= formatter.format(property.getSqft()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Dwelling Style</td><td><%= property.getDwelling() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Roof Material</td><td><%= property.getRoofmtl() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Garage Type</td><td><%= property.getGarage() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Number of Full Baths</td><td><%= property.getBaths() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Number of Half Baths</td><td><%= property.getHalfbaths() %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Has Swimming Pool?</td><td><%= property.getPool()==1 ? "Yes" : "No" %></td>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>
								<td colspan="2" style="font-weight: bold;">Coverage Details<br/></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Monthly Premium</td><td>$<%= formatter.format(quote.getMnthlypremium()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Dwelling Coverage</td><td>$<%= formatter.format(quote.getDwellingcoverage()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Detached Structures</td><td>$<%= formatter.format(quote.getDetachedstructure()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Personal Property</td><td>$<%= formatter.format(quote.getPersonalproperty()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Additional living expense</td><td>$<%= formatter.format(quote.getAddllivingexpense()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Medical expense</td><td>$<%= formatter.format(quote.getMedicalexpense()) %></td>
							</tr>
							<tr>
								<td style="font-style: oblique;">Deductible</td><td>$<%= formatter.format(quote.getDeductible()) %></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<button type="submit" value="Buy Quote">Buy Quote</button>
		</form>
	</div>
	<br/><br/><br/><br/><br/><br/>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>