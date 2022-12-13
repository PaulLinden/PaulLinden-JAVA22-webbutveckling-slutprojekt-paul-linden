package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		
		request.setAttribute("outlog", "You are successfully logged out!");
		
		response.setContentType("text/html");
		request.getRequestDispatcher("./Index.jsp").include(request, response);
		
		session.removeAttribute("name");
		System.out.println("Name is: " + session.getAttribute("name"));
		request.getSession(false).invalidate();
		
		System.out.println("You are successfully logged out!");
		out.close();
		
		response.sendRedirect("./Index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
