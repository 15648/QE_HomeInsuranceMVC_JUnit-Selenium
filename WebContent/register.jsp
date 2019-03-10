<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Register</title>
</head>
<body>
	<div id="header">
		<%@include file="header.html"%>
	</div>
	<% 
		if(request.getAttribute("message") == null)
			request.setAttribute("message", "");
	%>
	<div class="center">
		<h2>User Details</h2>
		<br/>
		<br/>
		<br/>
		Note: Password must be 8 characters with numbers and characters only.
		<br/>
		<br/>
		<br/>
		<div class="center">
		<form action="RegisterMe" id="login" method="post">
			<table>
				<tr><td colspan="2"><span style="color: red;"><%= request.getAttribute("message") %></span></td></tr>
				<tr><td><b>User id</b></td><td><input type="text" name="username"/></td></tr>
				<tr><td><b>Password</b></td><td><input type="password" name="password" pattern="[a-zA-Z0-9]{8,}" title="Must contain at least 8 or more numbers/characters"></td></tr>
				<tr><td><b>Re-enter password</b></td><td><input type="password" name="repassword" pattern="[a-zA-Z0-9]{8,}" title="Must contain at least 8 or more numbers/characters"/></td></tr>
				<tr><td></td><td><input type="submit" name="submit" value="Register"/></td></tr>
				<tr><td></td><td>Already Registered?<br/><a href="index.jsp">Login here</a></td></tr>
			</table>
		</form>
		</div>
	</div>	
	<br/>
	<br/>
	<br/>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>