<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.AccountBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second page</title>
<link rel="stylesheet" href="MainCss.css">
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

	<h2>SECOND PAGE</h2>
	<p>Lorem Ipsum is simply dummy text of the printing and typesetting
		industry. Lorem Ipsum has been the industry's standard dummy text ever
		since the 1500s, when an unknown printer took a galley of type and
		scrambled it to make a type specimen book. It has survived not only
		five centuries, but also the leap into electronic typesetting,
		remaining essentially unchanged. It was popularised in the 1960s with
		the release of Letraset sheets containing Lorem Ipsum passages, and
		more recently with desktop publishing software like Aldus PageMaker
		including versions of Lorem Ipsum.</p>
		
		<form action="<%=request.getContextPath()%>/OWservlet" method="get" name="theNumber">
         
         <%
         Integer hitsCount = (Integer)application.getAttribute("count");
        
         if( hitsCount ==null || hitsCount == 0 ) {
            hitsCount = 1;
         } else {
            hitsCount += 1;
         }
         application.setAttribute("count", hitsCount);

     	 %>
        <input type="hidden" name="counter" id="counter" value="Haj"/> 
         
         <p>Total number of visits: <%= hitsCount%></p>
     	
     	
      </form>

	<jsp:include page="./Footer.jsp"></jsp:include>
</body>
</html>