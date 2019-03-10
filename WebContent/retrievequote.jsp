<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Retrieve Quote</title>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.text.DecimalFormat" %>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<div class="center">
	<% 
		NumberFormat formatter = new DecimalFormat("#0.00");
		if(request.getAttribute("quotes") == null || request.getAttribute("quotes").equals(0)){
			request.setAttribute("message", "No quotes to display.");
		}			
		else{
			request.setAttribute("message", "");
			String strRepeat = request.getAttribute("quotes").toString();
			int repeat = Integer.parseInt(strRepeat);
		%>
		<table>
		<%
			for(int i = 0; i < repeat;  i++)
			{
		%>
			<tr>
				<td>QuoteId:<br/><%=request.getAttribute("quote_"+i+"_quoteid") %></td>
				<td>LocationId:<br/><%= request.getAttribute("quote_"+i+"_locationid") %></td>
				<td>Monthly Premium:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_mnthlypremium")) %></td>
				<td>Dwelling Coverage:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_dwellingcoverage")) %></td>
				<td>Detached Structure:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_detachedstructure")) %></td>
				<td>Personal Property:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_personalproperty")) %></td>
				<td>Additional Living Expense:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_addllivingexpense")) %></td>
				<td>Medical Expense:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_medicalexpense")) %></td>
				<td>Deductible:<br/>$<%= formatter.format(request.getAttribute("quote_"+i+"_deductible")) %></td>
			</tr>
		<%
			}
		}
	%>
	<%= request.getAttribute("message") %>
	</table>
	</div>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>