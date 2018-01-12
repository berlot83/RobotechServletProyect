package com.cognizant.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.cognizant.entities.User;
import com.cognizant.storageManager.DBManagerUser;

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Hola mundo");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/wellcome.jsp";
		String user = request.getParameter("user");
		String password = request.getParameter("password");

		try {
			
			ArrayList<User> users = DBManagerUser.retriveAllUsers();
			
			if ( DBManagerUser.retriveUser(user, password) == true) {
				response.getWriter().append("Hola mundo");
				HttpSession session = request.getSession();
				
				/*	Creamos un nuevo usuario y lo persistimos en la session	*/
				User newUser = new User(user, password);
				
				/*	Seteamos la sessión y le damos un atributo	*/
				session.setAttribute("user", user);
				
				/*	Derivamos la derivamos al usuario a otra página	*/
				getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
				response.getWriter().append("Chau mundo");
				getServletConfig().getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} catch (Exception error) {
			error.printStackTrace();
		}
	
	}
	
}
