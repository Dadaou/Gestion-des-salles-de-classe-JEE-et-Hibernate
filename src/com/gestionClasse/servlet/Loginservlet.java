package com.gestionClasse.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Loginservlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			String action = request.getParameter("action").toString();
			
			if(action.equals("login")){
			
			String login = request.getParameter("login").toString();
			String password = request.getParameter("password").toString();
			
			
			if(login.equals("Admin") && password.equals("admin000")) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
			}
			
			else this.getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
			
			}
			
		
		
	}

}
