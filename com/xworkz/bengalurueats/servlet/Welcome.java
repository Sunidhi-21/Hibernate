package com.xworkz.bengalurueats.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login credentials");
		
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username:"+username);
		System.out.println("Password:"+password);
		
		if((username.equals("Sunidhi-N"))&&(password.equals("123456"))){
			
			HttpSession session=request.getSession();
			session.setAttribute("usernameInSession",username);
			session.setAttribute("passwordInSession",password);
			session.setMaxInactiveInterval(12);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeDAOImpl");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.html");
			dispatcher.forward(request, response);
		}
	}

}
