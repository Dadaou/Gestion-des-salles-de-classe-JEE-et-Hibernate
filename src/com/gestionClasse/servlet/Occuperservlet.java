package com.gestionClasse.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionClasse.data.Occuperdata;
import com.gestionClasse.model.Occuper;


@WebServlet("/Occuperservlet")
public class Occuperservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Occuperservlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Occuperdata occuperdata = new Occuperdata();
		
		List<String> getTheCodeProf = occuperdata.getMyCodeProf();
		request.setAttribute("CodeProfs", getTheCodeProf);
		List<String> getTheCodeSalle = occuperdata.getMyCodeSalle();
		request.setAttribute("CodeSalles", getTheCodeSalle);
		
		if((request.getParameter("action") != null)){
			
			if(request.getParameter("action").equals("supprimer")) {
				
				String codeprof = request.getParameter("codeprof").toString();
				String codesalle = request.getParameter("codesalle").toString();
				
				
				Occuper occuper = new Occuper();
				
				occuper.setCodeprof(codeprof);
				occuper.setCodesalle(codesalle);
				
				
				occuperdata.deleteDataOccuper(occuper);
				
				List<Occuper> getOccuper = occuperdata.getAllOccuper();
				request.setAttribute("Occupes", getOccuper);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/listOccuper.jsp").forward(request, response);
				
			   
			}
			
			if(request.getParameter("action").equals("modifier")) {
				
				String codeprof = request.getParameter("codeprof").toString();
				String codesalle = request.getParameter("codesalle").toString();
				
				Occuper occuper = new Occuper();
		
				
				occuper = occuperdata.getOccuper(codeprof,codesalle);
				
				request.setAttribute("occuper", occuper);
				
				
				request.setAttribute("action", "modifier");
				this.getServletContext().getRequestDispatcher("/WEB-INF/modifOccuper.jsp").forward(request, response);
			}
	
		}
		
		else {
			
			List<Occuper> getOccuper = occuperdata.getAllOccuper();
			
			
			
			/*for(Occuper elem : getOccuper) {
				
				System.out.println(elem);
			}*/
			
			request.setAttribute("Occupes", getOccuper);
			
		}
		
		String thePath = request.getServletPath();
		if(thePath.equals("/occuper")) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/listOccuper.jsp").forward(request, response); 
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/registerOccuper.jsp").forward(request, response); 
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String action = request.getParameter("action").toString();
		
		if(action.equals("new")){
			
			String codeprof = request.getParameter("codeprof").toString();
			String codesalle = request.getParameter("codesalle").toString();
			String thedate = request.getParameter("thedate");
			
			
			try {
				
				Date date1 = java.sql.Date.valueOf(thedate);
				
				Occuper occuper = new Occuper();
				
				occuper.setCodeprof(codeprof);
				occuper.setCodesalle(codesalle);
				occuper.setThedate(date1);
				
				Occuperdata occuperdata = new Occuperdata();
				occuperdata.insertDataOccuper(occuper);
				
				
				List<Occuper> getOccuper = occuperdata.getAllOccuper();
				request.setAttribute("Occupes", getOccuper);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/listOccuper.jsp").forward(request, response);
			}
			catch(Exception e) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/ErrorOccuper.jsp").forward(request, response);
			}
			
		
		}
			
			else if(action.equals("modifier")){
				
				String codeprof = request.getParameter("codeprof").toString();
				String codesalle = request.getParameter("codesalle").toString();
				String thedate = request.getParameter("thedate").toString();		
				
				try {
					
					
				Date date2 = java.sql.Date.valueOf(thedate);
				
				Occuper occuper = new Occuper();
				
				occuper.setCodeprof(codeprof);
				occuper.setCodesalle(codesalle);
				occuper.setThedate(date2);
				
				Occuperdata occuperdata = new Occuperdata();
				occuperdata.updateDataOccuper(occuper);
			
				List<Occuper> getOccuper = occuperdata.getAllOccuper();
				request.setAttribute("Occupes", getOccuper);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/listOccuper.jsp").forward(request, response);
				
				}
				
				catch(Exception e) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
				}
				
			}
		
		
	}

	
}
