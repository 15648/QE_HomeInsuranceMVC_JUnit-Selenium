<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/css/style.css" var="myvar" />
<link href="${myvar}" rel="stylesheet" type="text/css" />
<%@page import = "java.util.List" %>
<%@page import = "casestudy.homeinsurance.model.Policy" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin -- User Policies</title>
</head>
<body>
	<div id="header">
		<%@include file="adminheader.html"%>
	</div>
	<div class="center">
	<% 
		List<Policy> policies = (List<Policy>)request.getAttribute("policies");
		if(policies.size()==0)
		{
			request.setAttribute("message", "No policies to display.");
		}			
		else
		{
			request.setAttribute("message", "");
		}
	%>
	${message}
	<table>
	<%
	for(Policy p : policies)
	{
	%>
			<tr>
				<td>PolicyId:<br/><%= p.getPolicyid() %></td>
				<td>UserId:<br/><%= p.getUserid() %></td>
				<td>QuoteId:<br/><%= p.getQuoteid() %></td>
				<td>Effective Date:<br/><%= p.getEffectiveDate() %></td>
				<td>End Date:<br/><%= p.getEndDate() %></td>
				<td>Term:<br/><%= p.getTerm() %></td>
				<td>Status:<br/><%= p.getStatus() %></td>
				<td>
					<a href="cancelorrenewpolicy?userid=<%= p.getUserid() %>&action=CANCELLED&policyid=<%= p.getPolicyid() %>"> <button>Cancel</button></a>
					<a href="cancelorrenewpolicy?userid=<%= p.getUserid() %>&action=RENEWED&policyid=<%= p.getPolicyid() %>"> <button>Renew</button></a>
					<a href="cancelorrenewpolicy?userid=<%= p.getUserid() %>&action=ACTIVE&policyid=<%= p.getPolicyid() %>"> <button>Active</button></a>
				</td>
			</tr>
	<%
	}
	%>
	</table>
	</div>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>