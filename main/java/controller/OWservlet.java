package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GettheWeather;
import model.weatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public OWservlet() {
    	super();
    	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		weatherBean wBean = new weatherBean(city, country);
		
		try {
		GettheWeather.getWeather(wBean);
		}
		catch(IOException e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Main.jsp");
			requestDispatcher.forward(request, response);
			}

		request.setAttribute("wBean", wBean);
		response.setContentType("text/html"); 
		
		String cookieCreater ="cookieCreater";
		String value = city+".."+country+".";
				
		Cookie weatherCookie = new Cookie (cookieCreater, value);
	
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
			
			if(cookie.getName().equals("cookieCreater")) {
				weatherCookie.setValue(cookie.getValue()+ "<br>" + value);
			}
		}
	}
				weatherCookie.setPath("/");
				weatherCookie.setMaxAge(60);
				System.out.println(weatherCookie.getName() + " A cookie has been created successfully! " + weatherCookie.getValue());
				response.addCookie(weatherCookie);
				System.out.println("............................................");
		
		
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Main.jsp");
				requestDispatcher.forward(request, response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
