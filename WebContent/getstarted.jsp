<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Get Started</title>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<div class="center">
		<h2>Get Started Page</h2>
		<br/><br/><br/>
		<table>
			<tr>
				<td><img src="getstartedpage.PNG" width="275px" height="180px"/></td>
				<td><div width="300px"> </div></td>
				<td width = "250px"></td>
				<td width = "250px">
					<a href="getquote.jsp"><button>Get a Quote</button></a><br/>
					<br/>
					<a href="RetrieveQuote"><button>Retrieve a Quote</button></a><br/>
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