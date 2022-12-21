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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city");
		String country = request.getParameter("country");

		weatherBean wBean = new weatherBean(city, country);

		try {
			GettheWeather.getWeather(wBean);
		} catch (IOException e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Main.jsp");
			requestDispatcher.forward(request, response);
		}
		request.setAttribute("wBean", wBean);
		response.setContentType("text/html");

//--------------------------------------------------------------------------------------------------------------------//		
// -------------- Create Cookie for location--------------------------------------------------------------------------//

		String addLocationName = "cookieLocation";

		String addLocationValue = city + "-" + country + ".@";

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				if (cookie.getName().equals("consent") && cookie.getValue().equals("yes")) {
				
					Cookie locationCookie = new Cookie(addLocationName, addLocationValue);

					if (cookies != null) {

						for (Cookie cookien : cookies) {

							if (cookien.getName().equals("cookieLocation")) {
								locationCookie.setValue(cookien.getValue() + addLocationValue);
							}
						}
					}
					locationCookie.setPath("/");
					locationCookie.setMaxAge(60);
					System.out.println(locationCookie.getName() + " A cookie has been created successfully! "
							+ locationCookie.getValue());
					response.addCookie(locationCookie);
					System.out.println("............................................");
				}
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Main.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
