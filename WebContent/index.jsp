<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance -- Login</title>
</head>
<body>
	<div id="header">
		<%@include file="header.html"%>
	</div>
	<center>
		<form action="LoginCheck" id="login" method="post">
			<table>
				<tr>
					<td>
						<p>
						<em>
							Home insurance, also commonly called hazard<br/>
							insurance or homeowner's insurance, is a type of<br/>
							property insurance that covers a private residence,<br/>
							such as a condominium or renters' insurance or<br/>
							home or multiple unit buildings.
						</em>
						</p>
						<p>
						<em>
							It is an insurance policy that combines various<br/>
							personal insurance protections, which can include<br/>
							losses occurring to one's home, its contents, loss of<br/>
							use (additional living expenses), or loss of other<br/>
							personal possessions of the homeowner; as well as<br/>
							liability insurance for accidents that may happen at<br/>
							the home or at the hands of the homeowner within<br/>
							the policy territory. If a home does not meet the<br/>
							underwriting guidelines of a standard homeowners<br/>
							policy the residence could qualify for a limited<br/>
							coverage dwelling policy.
						</em>
						</p>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td align="center">
						<table>
							<tr>
								<td colspan="2" align="center"><img src="Capturehouse.PNG"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<% 
										if(request.getAttribute("message") == null){
											request.setAttribute("message", "");
										}
									%>
									<span style="color: red;"><%= request.getAttribute("message") %></span>					
								</td>
							</tr>
							<tr>
								<td><b>User id</b></td>
								<td><input type="text" name="username"/></td>
							</tr>
							<tr>
								<td><b>Password</b></td>
								<td><input type="password" name="password"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<p><input type="submit" name="submit" value="Login"/></p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									New User? <a href="register.jsp">Register here</a>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									Admin User? <a href="admin/adminlogin">Login here</a>
								</td>
							</tr>
						</table>
					</td>
			</table>
		</form>
	</center>	
	<div id="footer">
		<%@include file="footer.html"%>
	</div>
</body>
</html>