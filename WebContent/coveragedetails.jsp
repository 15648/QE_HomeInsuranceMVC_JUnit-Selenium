<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Coverage Details</title>
<%@page import="casestudy.homeinsurance.model.Quote" %>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.text.DecimalFormat" %>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<% 
		Quote quote = (Quote) session.getAttribute("quote"); 
		NumberFormat formatter = new DecimalFormat("#0.00");   
	%>
	<div class="center">
		<h2>Coverage Details</h2>
		<br/><br/><br/>
		<table style="width: 800px;">
			<tr>
				<td><img src="getstartedpage.PNG" width="275px" height="180px"/></td>
				<td>
					<form action="summary.jsp" method="get">
						<table>
							<tr><td></td><td><a href="addlinfo.html" target="_blank">Additional info</a></td>
							<tr><td>Quote Id</td><td><%= quote.getQuoteid() %></td></tr>
							<tr><td>Monthly Premium</td><td>$<%= formatter.format(quote.getMnthlypremium()) %></td></tr>
							<tr><td>Dwelling Coverage</td><td>$<%= formatter.format(quote.getDwellingcoverage()) %></td></tr>
							<tr><td>Detached Structures</td><td>$<%= formatter.format(quote.getDetachedstructure()) %></td></tr>
							<tr><td>Personal Property</td><td>$<%= formatter.format(quote.getPersonalproperty()) %></td></tr>
							<tr><td>Additional living expense</td><td>$<%= formatter.format(quote.getAddllivingexpense()) %></td></tr>
							<tr><td>Medical Expense</td><td>$<%= formatter.format(quote.getMedicalexpense()) %></td></tr>
							<tr><td>Deductible</td><td>$<%= formatter.format(quote.getDeductible()) %></td></tr>
							<tr><td colspan="2"><input type="submit" name="submit" value="Proceed to buy"/></td></tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<br/><br/><br/>
		<br/><br/><br/>
	</div>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>