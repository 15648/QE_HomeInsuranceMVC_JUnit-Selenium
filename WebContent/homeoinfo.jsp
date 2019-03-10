<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Homeowner Information</title>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<div class="center">
		<h2>Homeowner Information</h2>
		<br/><br/><br/>
		<table style="width: 800px;">
			<tr>
				<td><img src="getstartedpage.PNG" width="275px" height="180px"/></td>
				<td>
					<form action="SetHomeowner" method="get">
						<table>
							<tr><td>First Name</td><td><input type="text" name="fname" required pattern="[a-zA-Z ]{2,30}" title="Only use 2-50 letters, numbers and spaces."/></td></tr>
							<tr><td>Last Name</td><td><input type="text" name="lname" pattern="[a-zA-Z ]{2,30}" title="Can be up to 100 letters, numbers and spaces."/></td></tr>
							<tr><td>Date of Birth</td><td><input type="text" required name="dob" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" title="Use yyyy-MM-dd year must begin 19## or 20##."/></td></tr>
							<tr><td>Are you retired?</td><td><input type="radio" required name="retired" value="1"/>Yes<input type="radio" required name="retired" value="0"/>No</td></tr>
							<tr><td>Social Security Number</td><td><input type="text" required  name="ssn" pattern="[0-9]{9}" title="No dashes like: #########"/></td></tr>
							<tr><td>Email Address</td><td><input type="text" required  name="email" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" title="Input a proper email"/></td></tr>
							<tr><td colspan="2"><input type="submit" name="submit" value="Continue"/></td></tr>
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