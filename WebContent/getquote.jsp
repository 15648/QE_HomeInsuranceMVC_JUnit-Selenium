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
		<table style="width: 800px;">
			<tr>
				<td><img src="getstartedpage.PNG" width="275px" height="180px"/></td>
				<td>
					<form action="GetQuote" method="get">
						<table>
							<tr><td>Residence Type</td>
								<td><select name="restype">
										<option value="Single-Family Home">Single-Family Home</option>
										<option value="Condo">Condo</option>
										<option value="Townhouse">Townhouse</option>
										<option value="Rowhouse">Rowhouse</option>
										<option value="Duplex">Duplex</option>
										<option value="Apartment">Apartment</option>
									</select></td>
							</tr>
							<tr><td>Address Line 1</td><td><input type="text" required name="addr1"  pattern="[a-zA-Z0-9 ]{8,50}" title="Only use 8-50 letters, numbers and spaces."/></td></tr>
							<tr><td>Address Line 2</td><td><input type="text" name="addr2" pattern="[a-zA-Z0-9 ]{0,100}" title="Can be up to 100 letters, numbers and spaces."/></td></tr>
							<tr><td>State</td><td><input type="text" required name="statename" pattern="[A-Za-z ]{1,15}" title="Use 15 or less letters."/></td></tr>
							<tr><td>City</td><td><input type="text" required name="city" pattern="[A-Za-z ]{1,15}" title="Use 15 or less letters."/></td></tr>
							<tr><td>Zip</td><td><input type="text" required  name="zip" pattern="[0-9]{5}(-[0-9]{4})?" title="Use ##### or #####-####"/></td></tr>
							<tr><td>Residence Use</td>
							<td><select name="resuse">
										<option value="Primary">Primary</option>
										<option value="Secondary">Secondary</option>
										<option value="Rental Property">Rental Property</option>
									</select></td>
							</tr>
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