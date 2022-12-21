package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Consent")
public class Consent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Consent() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("yes") != null) {
			
			Cookie consentCookie = new Cookie("consent", "yes");

			consentCookie.setPath("/");
			consentCookie.setMaxAge(200);

			response.addCookie(consentCookie);

			System.out.println(consentCookie.getName() + "==" + consentCookie.getValue());
		} 
		else if (request.getParameter("no") != null) {
			Cookie consentCookie = new Cookie("consent", "no");
			
			consentCookie.setPath("/");
			consentCookie.setMaxAge(200);

			response.addCookie(consentCookie);
		}
		
		String remove = "remove";
		request.setAttribute("remove", remove);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Index.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
