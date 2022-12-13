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

			Username: <input type="text" name="u_name" placeholder=" Username" class="inputUser"/> 
			<br> 
			<br>
			Password: <input type="text" name="pass" placeholder=" ********" class="inputUser"/> 
			<br>
			<br> 
		<div>
			<input type="submit" value="Login" class="inputButton"/>
			<br>
			<br> 
			<% 
			if (request.getAttribute("mess") != null) {
				out.print("<span>" + request.getAttribute("mess") +"</span>");
			}
			else if (request.getAttribute("outlog") != null) {
				out.print("<span>" + request.getAttribute("outlog") +"</span>");
			}
			%>
		</div>	
			
			
			
		</form>
	
	</nav>

</body>
</html>