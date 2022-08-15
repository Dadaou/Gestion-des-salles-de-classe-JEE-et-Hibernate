package com.gestionClasse.servlet;

import java.io.IOException;

import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.gestionClasse.data.Occuperdata;
import com.gestionClasse.data.Profdata;
//import com.gestionClasse.model.Occuper;
import com.gestionClasse.model.Prof;



@WebServlet("/Profsevlet")
public class Profservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Profservlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Profdata profdata = new Profdata();
		
		
		if((request.getParameter("action") != null)){
			
			if(request.getParameter("action").equals("supprimer")) {
				
				String codeprof = request.getParameter("codeprof").toString();
				Prof prof =new Prof();
				prof.setCodeprof(codeprof);
				profdata.deleteDataProf(prof);
				
				List<Prof> getProf = profdata. getAllProf();
				request.setAttribute("Profs", getProf);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/listProf.jsp").forward(request, response);
			}
			
			if(request.getParameter("action").equals("modifier")) {
				
				String codeprof = request.getParameter("codeprof").toString();
				
				Prof prof =new Prof();
				prof = profdata.getProf(codeprof);
				request.setAttribute("prof", prof);
				request.setAttribute("action", "modifier");
				this.getServletContext().getRequestDispatcher("/WEB-INF/modifProf.jsp").forward(request, response);
			}
			
			
		}
		else {
			
			List<Prof> getProf = profdata. getAllProf();
			request.setAttribute("Profs", getProf);
			
		}
		
		
		String thePath = request.getServletPath();
		if(thePath.equals("/prof")) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listProf.jsp").forward(request, response); 
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/registerProf.jsp").forward(request, response); 
		}
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String action = request.getParameter("action").toString();
		
		
		if(action.equals("new")){
		
			String codeprof = request.getParameter("codeprof").toString();
			String nom = request.getParameter("nom").toString();
			String prenom = request.getParameter("prenom").toString();
			String grade = request.getParameter("grade").toString();
			
			
			try {
			Prof prof=new Prof();
			
		    prof.setCodeprof(codeprof);
			prof.setNom(nom);
			prof.setPrenom(prenom);
			prof.setGrade(grade);
			
			Profdata profdata = new Profdata();
			profdata.insertDataProf(prof);
			
			List<Prof> getProf = profdata. getAllProf();
			request.setAttribute("Profs", getProf);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listProf.jsp").forward(request, response);
			
			}
			
			catch(Exception e) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/ErrorProf.jsp").forward(request, response);
			}
		}
		else if(action.equals("modifier")){
			
			String codeprof = request.getParameter("codeprof").toString();
			String nom = request.getParameter("nom").toString();
			String prenom = request.getParameter("prenom").toString();
			String grade = request.getParameter("grade").toString();
			
		
			try {
				
			Prof prof = new Prof();
			
			prof.setCodeprof(codeprof);
			prof.setNom(nom);
			prof.setPrenom(prenom);
			prof.setGrade(grade);
			
			Profdata profdata = new Profdata();
			profdata.updateDataProf(prof);
			
			List<Prof> getProf = profdata.getAllProf();
			request.setAttribute("Profs", getProf);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listProf.jsp").forward(request, response);
		
		}
			catch(Exception e) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
			}
			
		}
		
		else if(action.equals("rechercher")){
			
			String nomOuCode = request.getParameter("nameSearch").toString();	
			String critere = request.getParameter("codeSearch").toString();
			
			System.out.println(critere);
			
			Profdata profdata = new Profdata();
			
			if(critere.equals("code")) {
				
				List<Prof> getResult = profdata.getProfByCodeProf(nomOuCode);
				request.setAttribute("Profs", getResult);
			}
			
			if(critere.equals("nom")) {
				
				List<Prof> getResult = profdata.getProfByName(nomOuCode);
				request.setAttribute("Profs", getResult);
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listProf.jsp").forward(request, response);
			
		}
	}
	

}
