<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Property Details</title>
</head>
<body>
	<div id="header">
		<%@include file="headerwithlinks.html"%>
	</div>
	<div class="center">
		<h2>Property Details</h2>
		<br/><br/><br/>
		<form action="SetProperty" method="get">
		<table>
			<tr>
				<td>
						<table>
							<tr><td>What is the market value of your home?</td><td><input type="text" required name="mktval" pattern="[0-9]{1,}(.[0-9]{0,2})?" title="Enter proper dollar number."/></td></tr>
							<tr><td>What year was your home originally built?</td><td><input type="text" required name="yr" pattern="[0-9]{4}" title="Use 4-digit year"/></td></tr>
							<tr><td>Square footage</td><td><input type="text" required name="sqft" pattern="[0-9]{1,}(.[0-9]{0,2})?" title="Use at most 2 digits after demical point."/></td></tr>
							<tr><td>Dwelling style</td><td><select name="dwelling">
																<option value="1 story">1 story</option>
																<option value="1.5 story">1.5 story</option>
																<option value="2 story">2 story</option>
																<option value="2.5 story">2.5 story</option>
																<option value="3 story">3 story</option>
															</select>
														</td>
							</tr>
							<tr><td>Roof Material</td><td><select name="roofmtl">
																<option value="Concrete">Concrete</option>
																<option value="Clay">Clay</option>
																<option value="Rubber">Rubber</option>
																<option value="Steel">Steel</option>
																<option value="Tin">Tin</option>
																<option value="Wood">Wood</option>
															</select>
														</td>
							</tr>
							<tr><td>Type of Garage</td><td><select name="garage">
																<option value="Attached">Attached</option>
																<option value="Detached">Detached</option>
																<option value="Basement">Basement</option>
																<option value="Built-in">Built-in</option>
																<option value="None">None</option>
															</select>
														</td>
							</tr>
							<tr><td>Number of full baths</td><td><select name="baths">
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
																<option value="4">4</option>
																<option value="0">0</option>
															</select>
														</td>
							</tr>
							<tr><td>Number half baths</td><td><select name="halfbaths">
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
																<option value="4">4</option>
																<option value="0">0</option>
															</select>
														</td>
							</tr>
							<tr><td>Does your home have a swimming pool?</td><td><input type="radio" required name="pool" value="1"/>Yes<input type="radio" required name="pool" value="0"/>No</td></tr>
							<tr><td colspan="2"><input type="submit" name="submit" value="Continue"/></td></tr>
						</table>
				</td>
			</tr>
		</table>
		</form>
		<br/><br/><br/>
		<br/><br/><br/>
	</div>
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>