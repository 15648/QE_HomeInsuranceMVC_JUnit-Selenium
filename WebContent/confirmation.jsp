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
<title>Home Insurance -- Policy Confirmation</title>
<%@page import="casestudy.homeinsurance.model.Policy" %>
</head>
<body onLoad="disable()">
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<% 	
		Policy policy = (Policy) session.getAttribute("policy");
	%>
	<div class="center">
		<h2>Policy Confirmation</h2>
		<br/><br/><br/><br/>
		<table style="width: 800px;">
			<tr>
				<td><img src="getstartedpage.PNG" width="275px" height="180px"/></td>
				<td>
					<form action="GetQuote" method="get">
						<table>
							<tr><td colspan="2"><p style="text-align: center; font-weight: bold;">Our customer service representative will contact you<br/>shortly for premium collection arrangements.</p><td><tr>
							<tr><td>Quote Id</td><td><%= policy.getQuoteid() %></td></tr>
							<tr><td>Policy Key</td><td><%= policy.getPolicyid() %></td></tr>
							<tr><td>Policy Effective Date</td><td><%= policy.getEffectiveDate() %></td></tr>
							<tr><td>Policy End Date</td><td><%= policy.getEndDate() %></td></tr>
							<tr><td>Policy Term</td><td><%= policy.getTerm() %></td></tr>
							<tr><td>Policy Status</td><td><%= policy.getStatus() %></td></tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<br/><br/><br/>
	<br/><br/><br/>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>