package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Consent")
public class Consent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Consent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int day = 1; 
		 if(day == 1 ){ 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
				
			 out.print("	<form action=\"Index.jsp\"> ");
			 out.print("	<input type=\"button\" name=\"'yes\" class=\"yes\"/> ");
			 out.print("	<input type=\"button\" name=\"no\" class=\"no\"/> ");
			 out.print(" </form> ");
		}	
		 	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Index.jsp");
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
