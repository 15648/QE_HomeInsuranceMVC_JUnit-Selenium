<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function disable()
{
	document.getElementById("submit").disabled=true;
}
function enable()
{
    document.getElementById("submit").disabled=false;
}

</script>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Buy Policy</title>
<%@page import="casestudy.homeinsurance.model.Quote" %>
</head>
<body onLoad="disable()">
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<% 	
		Quote quote = (Quote) session.getAttribute("quote");
		
	%>
	<div class="center">
		<h2>Buy Policy</h2>
		<br/><br/><br/><br/>
		<p><b>Quote Id:</b><%= quote.getQuoteid() %></p>
		<p><b><span style="color: red;">Note:</span> Policy start date cannot be more than 60 days from today's date</b></p>
		<form action="BuyPolicy" method="get" onkeypress="return event.keyCode != 13;">
			<p>Enter Policy Start Date: <input name="startDate" type="text" 
				required 
				pattern="<%= request.getAttribute("regex").toString() %>" 
				title="<%= request.getAttribute("regexTitle").toString() %>"/> MM/dd/yyyy -- (for any month you must use today's date)
			</p>
			<p><a href="terms.html" target="_blank">Please click and read terms and conditions before buying policy</a></p>
			<p><input type="radio" id="read" value="read" onClick="enable()"/>This is to acknowledge that I have read the terms and conditions of the policy</p>
			<p><input type ="submit" id="submit" name="submit" value="Submit"/></p>
		</form>
	</div>
	<br/><br/><br/><br/><br/><br/>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>