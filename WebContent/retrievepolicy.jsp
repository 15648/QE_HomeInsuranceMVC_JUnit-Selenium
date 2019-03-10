<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Retrieve Quote</title>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<div class="center">
	<% 
		if(request.getAttribute("policies") == null || request.getAttribute("policies").equals(0)){
			request.setAttribute("message", "No policies to display.");
		}			
		else{
			request.setAttribute("message", "");
			String strRepeat = request.getAttribute("policies").toString();
			int repeat = Integer.parseInt(strRepeat);
		%>
		<table>
		<%
			for(int i = 0; i < repeat;  i++)
			{
		%>
			<tr>
				<td>PolicyId:<br/><%=request.getAttribute("policy_"+i+"_policyid") %></td>
				<td>UserId:<br/><%=request.getAttribute("policy_"+i+"_userid") %></td>
				<td>QuoteId:<br/><%=request.getAttribute("policy_"+i+"_quoteid") %></td>
				<td>Effective Date:<br/><%=request.getAttribute("policy_"+i+"_effectivedate") %></td>
				<td>End Date:<br/><%=request.getAttribute("policy_"+i+"_enddate") %></td>
				<td>Term:<br/><%=request.getAttribute("policy_"+i+"_term") %></td>
				<td>Status:<br/><%=request.getAttribute("policy_"+i+"_status") %></td>
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