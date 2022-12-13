<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.AccountBean"%>
<%@page import="model.weatherBean"%>
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
		
		<%

			AccountBean bean = (AccountBean) session.getAttribute("name");
			out.print("<h3> Welcome user: "  + bean.getUserName() + "</h3>");
			
		%>
	</nav>	
	<br>
	<h2>Todays Weather</h2>
	
	<form action="OWservlet" method="get">
			
			City:<input type="text" name="city" /><br /> 
			Country:<input type="text" name="country" /><br /> <input type="submit" value="go" />
			
			<span>
				<%
				weatherBean wBean = (weatherBean) request.getAttribute("wBean");
					
					if (request.getAttribute("wBean") != null){
					out.print("The weather in " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr() + ". Current Temperature is " + wBean.getTempStr() + " Celsius.");
					}
				%>
			</span>
	</form>


	<jsp:include page="./Footer.jsp"></jsp:include>

</body>
</html>