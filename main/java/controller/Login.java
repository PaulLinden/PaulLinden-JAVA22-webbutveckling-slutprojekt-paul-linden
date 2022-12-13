package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getSession(false) == null) {
			
			response.sendRedirect("Index.jsp");
			System.out.println("Nope!!");
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("u_name");
		String password = request.getParameter("pass");

		AccountBean bean = new AccountBean();

		bean.setUserName(username);
		bean.setPassword(password);

		String[] checkuser = bean.getUsernames();
		String[] checkpass = bean.getPasswords();

		int i;

		for (i = 0; i < checkuser.length; i++) {

			if (username.equals(checkuser[i]) && password.equals(checkpass[i])) {
				HttpSession session = request.getSession(false);
				
				if (request.getSession(false) == null) {
					session = request.getSession();
					System.out.println("Session created");
				} else {
					System.out.println("Session already exist");
				}
				
				session.setAttribute("name", bean);
				//session.setMaxInactiveInterval(5);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Main.jsp");
				requestDispatcher.forward(request, response);

				System.out.println("User: " + checkuser[i]);
				
			}
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		
		
		
		if (username.equals("") && password.equals("")) {
			request.setAttribute("mess", "Please insert username and password");
			rd.include(request, response);
		} 
		else {
			request.setAttribute("mess", "Wrong username or password");
			rd.include(request, response);
		}
		out.close();
	}

}
