package com.gestionClasse.data;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionClasse.model.Salle;

public class Salledata {
	
	public void insertDataSalle(Salle salle) {
	
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.save(salle);
			trans.commit();
		    session.close();
		    System.out.println("Salle ajouté...");
		
	}
	
	public List<Salle>  getAllSalle(){
		
		 List<Salle> SalleModel = new ArrayList<>();
		 Config conf = new Config();
		 Session session= conf.getSessionFactory().openSession();
		 Transaction trans = session.beginTransaction();
		 
		 Query query =  session.createQuery("FROM Salle");
		 SalleModel = query.list();
		 
	     trans.commit();
		 session.close();
		 
		 return  SalleModel;
	}
	
	public Salle getSalle(String codesalle){
				
		  String query = "FROM Salle salle WHERE salle.codesalle="+codesalle;
				
		  Config conf = new Config();
		  Session session= conf.getSessionFactory().openSession();
		  Transaction trans = session.beginTransaction();
				
		   Query query2 = session.createQuery(query);
				
		   Salle salle = new Salle();
				
		   salle = (Salle)query2.list().get(0);
		   
		   trans.commit();
		   session.close();
						
	      return salle;
	}

	
	public void deleteDataSalle(Salle salle) {
		try {
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(salle);
			trans.commit();
		    session.close();
		    System.out.println("Salle supprimé...");
		
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateDataSalle(Salle salle) {
		
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.update(salle);
			trans.commit();
		    session.close();
		    System.out.println("Salle modifié...");
		
	
	}

}
