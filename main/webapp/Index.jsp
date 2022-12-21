<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebApp</title>
<link rel="stylesheet" href="views/MainCss.css">
</head>
<body>

	<header>

		<h1>Login Page</h1>

	</header>
	<nav>
		<form action="<%=request.getContextPath()%>/Login" method="post">

			Username: <input type="text" name="u_name" placeholder=" Username"
				class="inputUser" /> <br> <br> Password: <input
				type="text" name="pass" placeholder=" ********" class="inputUser" />
			<br> <br>
			<div>
				<input type="submit" value="Login" class="inputButton" /> <br>
				<br>
				<%
				if (request.getAttribute("mess") != null) {
					out.print("<span>" + request.getAttribute("mess") + "</span>");
				} else if (request.getAttribute("outlog") != null) {
					out.print("<span>" + request.getAttribute("outlog") + "</span>");
				}
				%>
			</div>
		</form>
	</nav>

	<%!String change = "cookieConsent";%>
	<%
	if(request.getAttribute("remove") == "remove"){
		change = "dontDisplay";
		request.removeAttribute("remove");
	}
	%>
	<%
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {

		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("consent")) {
				change = "dontDisplay";
			}
		}
	} 
	%>

	<form name="frm" method="get" action="Consent" class="<%=change%>">
			<input type="hidden" name="hidden" /> 
			Allow cookies: <input type="submit" name="yes" value="yes" class="inputButton"> 
			<input type="submit" name="no" value="no" class="inputButton">
	</form>
</body>
</html>