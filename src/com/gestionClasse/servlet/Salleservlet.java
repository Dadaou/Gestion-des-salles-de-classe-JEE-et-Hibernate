package com.gestionClasse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionClasse.data.Salledata;
import com.gestionClasse.model.Salle;


@WebServlet("/Salleservlet")
public class Salleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Salleservlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Salledata salledata = new Salledata();
		
		
		if((request.getParameter("action") != null)){
			
			if(request.getParameter("action").equals("supprimer")) {
				
				String codesalle = request.getParameter("codesalle").toString();
				Salle salle = new Salle();
				salle.setCodesalle(codesalle);
				salledata.deleteDataSalle(salle);
				
				List<Salle> getSalle = salledata. getAllSalle();
				request.setAttribute("Salles", getSalle);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/listSalle.jsp").forward(request, response);
			}
			
			if(request.getParameter("action").equals("modifier")) {
				
				String codesalle = request.getParameter("codesalle").toString();
				Salle salle = new Salle();
				salle = salledata.getSalle(codesalle);
				request.setAttribute("salle", salle);
				request.setAttribute("action", "modifier");
				this.getServletContext().getRequestDispatcher("/WEB-INF/modifSalle.jsp").forward(request, response);
			}
			
		}
		else {
			
			List<Salle> getSalle = salledata. getAllSalle();
			request.setAttribute("Salles", getSalle);
			
		}
		
		String thePath = request.getServletPath();
		
		if(thePath.equals("/salle")) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listSalle.jsp").forward(request, response); 
		}
		else if(thePath.equals("/newSalle")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/registerSalle.jsp").forward(request, response); 
		}
		else if(thePath.equals("/accueil")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
		
		String action = request.getParameter("action").toString();
		
		if(action.equals("new")){
		
			String codesalle = request.getParameter("codesalle").toString();
			String designation = request.getParameter("designation").toString();
			
			try {
			
			Salle salle = new Salle();
			
		    salle.setCodesalle(codesalle);
			salle.setDesignation(designation);
			
			Salledata salledata = new Salledata();
			salledata.insertDataSalle(salle);
			
		
			List<Salle> getSalle = salledata. getAllSalle();
			request.setAttribute("Salles", getSalle);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listSalle.jsp").forward(request, response);
			
			}
			catch(Exception e) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/ErrorSalle.jsp").forward(request, response);
			}
		}
		else if(action.equals("modifier")){
			
			String codesalle = request.getParameter("codesalle").toString();
			String designation = request.getParameter("designation").toString();
			
			try {
			Salle salle = new Salle();
			
			salle.setCodesalle(codesalle);
			salle.setDesignation(designation);
		
			
			Salledata salledata = new Salledata();
			salledata.updateDataSalle(salle);
			
			List<Salle> getSalle = salledata. getAllSalle();
			request.setAttribute("Salles", getSalle);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listSalle.jsp").forward(request, response);
			
		}
			catch(Exception e) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
			}
			
		}
	}
	

}
