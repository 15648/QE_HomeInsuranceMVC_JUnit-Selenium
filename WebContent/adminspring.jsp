<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/css/style.css" var="myvar" />
<link href="${myvar}" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Admin Login</title>
</head>
<body>
	<div id="header">
			<%@include file="header.html"%>
	</div>
	<h1>Admin Login</h1>
	<form action="findadmin" method="post">
		<%if(request.getAttribute("message") != null){ %>
		<h2><%= request.getAttribute("message") %></h2>
		<%} %>
		<p class="center"> 
			Username: <input type="text" name="username" /><br/>
			<br/>
			Password: <input type="password" name="password"/><br/>
			<br/>
			<input type ="submit" name="submit" value="Login" />
		</p>
	</form>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>