<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/css/style.css" var="myvar" />
<link href="${myvar}" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Admin Controls</title>
</head>
<body>
	<div id="header">
		<%@include file="adminheader.html"%>
	</div>
	<center>
		<p>Search User Policy:</p>
		<form action="finduser" method="post">
			<input type="text" name="username" />
			<input type="submit" name="submit" value="Search" />
		</form>
		${message}
	</center>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>