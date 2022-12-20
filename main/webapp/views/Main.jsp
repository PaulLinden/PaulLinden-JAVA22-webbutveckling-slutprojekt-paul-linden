<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.AccountBean"%>
<%@page import="model.weatherBean"%>
<%@page import= "java.util.ArrayList"%>
<%@page import= "java.time.LocalDateTime" %>
<%@page import= "java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main page</title>
<link rel="stylesheet" href="views/MainCss.css">
</head>
<body>
	
	<header>

		<jsp:include page="./Header.jsp"></jsp:include>
	
	</header>

	<nav class="pageNav">	
	
		<form action="<%=request.getContextPath()%>/changePage" method="get">

			<select name="Page">

				<option disabled selected>Choose</option>

				<option value="One">Main page</option>

				<option value="Two">Second page</option>

				<option value="Three">Third page</option>

				<option value="Logout">---Logout---</option>
		
			</select> <input type="submit" value="Submit" />
		
		
		
		</form>
		
	</nav>	
	<br>
	<h2>Todays Weather</h2>
	
	
	
	<form action="<%=request.getContextPath()%>/OWservlet" method="get" name="theCookie">
			
			<h4> <%LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("E, dd/MM HH:mm");
		String formattedDate = currentTime.format(formatTime);
		out.print(formattedDate);
		%>
		</h4>
			
			City:<input type="text" name="city" pattern=".{1,}[a-zA-Z]"  title="Only A-Z, a-z."/><br /> 
			Country:<input type="text" name="country" pattern=".{1,}[a-zA-Z]"  title="Only A-Z, a-z."/><br /> 
			<input type="submit" value="go"/>
			
	<span>
	<%
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");
					
		if (request.getAttribute("wBean") != null){
			out.print("The weather in " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr() + ". Current Temperature is " + wBean.getTempStr() + " " +wBean.getUnit() +".");
			out.print("<br>");
			out.print("Last update: " + wBean.getLastDate());
			}
		else{
			out.print("Input City and Country");
		}
	%>		
	</span>
	</form>
	<br>
	<br>
	
	<ul class="latestSearch">
	 <li >Cookie:</li>
 <% 
Cookie cookies[]=request.getCookies();  
   
  for (Cookie cookie : cookies) {
	  
	   switch(cookie.getName()){
	 
	   case "cookieCreater": 
		   out.print("<li >");
		   out.print(cookie.getValue());
		   out.print("</li>");   
   	}
 }
%>
	</ul>
	
	<jsp:include page="./Footer.jsp"></jsp:include>

</body>


</html>