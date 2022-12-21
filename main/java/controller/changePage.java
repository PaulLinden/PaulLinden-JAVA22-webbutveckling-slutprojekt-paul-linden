package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePage")
public class changePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public changePage() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession(false) == null) {

			System.out.println("Nice try!");

			response.sendRedirect("Index.jsp");
		} 
		else {

			String Page = request.getParameter("Page");
			String forward = "";

			if (Page == null) {
				forward = "views/Main.jsp";
			}
			else {

				switch (Page) {

				case "One":
					forward = "views/Main.jsp";
					break;
				case "Two":
					forward = "views/PageTwo.jsp";
					break;
				case "Three":
					forward = "views/PageThree.jsp";
					break;
				case "Logout":
					forward = "/Logout";
					break;
				}
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
