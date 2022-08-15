package com.gestionClasse.data;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionClasse.model.Occuper;


public class Occuperdata {
	
	
	public List<String>  getMyCodeProf(){
		
		 List<String> MyProfModel = new ArrayList<>();
		 Config conf = new Config();
		 Session session= conf.getSessionFactory().openSession();
		 Transaction trans = session.beginTransaction();
		 
		 Query query =  session.createQuery("SELECT prof.codeprof FROM Prof prof");
		 MyProfModel = query.list();
		 
	     trans.commit();
		 session.close();
		 
		 return  MyProfModel;
	}
	
	public List<String>  getMyCodeSalle(){
		
		 List<String> MySalleModel = new ArrayList<>();
		 Config conf = new Config();
		 Session session= conf.getSessionFactory().openSession();
		 Transaction trans = session.beginTransaction();
		 
		 Query query =  session.createQuery("SELECT salle.codesalle FROM Salle salle");
		 MySalleModel  = query.list();
		 
	     trans.commit();
		 session.close();
		 
		 return  MySalleModel ;
	}
	
	public List<Occuper>  getAllOccuper(){
		
		 List<Occuper> OccuperModel = new ArrayList<>();
		 Config conf = new Config();
		 Session session= conf.getSessionFactory().openSession();
		 Transaction trans = session.beginTransaction();
		 
		 Query query =  session.createQuery("FROM Occuper");
		 OccuperModel = query.list();
		 
	     trans.commit();
		 session.close();
		 
		 return  OccuperModel;
	}
	
	public Occuper getOccuper(String codeprof, String codesalle){
		
		  Occuper occuper = new Occuper();
		
		try {
		  String query = "FROM Occuper occuper WHERE occuper.codeprof="+ codeprof + "AND occuper.codesalle ="+ codesalle;
				
		  Config conf = new Config();
		  Session session= conf.getSessionFactory().openSession();
		  Transaction trans = session.beginTransaction();
		  
		   Query query2 = session.createQuery(query);
		  	
		   occuper = (Occuper)query2.list().get(0);
		   

		   trans.commit();
		   session.close();
		   
		 
		}
		catch (Exception e) {
			System.out.println(e);
		}
						

	    return occuper;
	}

	public void insertDataOccuper(Occuper occuper) {
	
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.save(occuper);
			trans.commit();
		    session.close();
		    System.out.println("ajouté...");
		
	
	}
	
	public void deleteDataOccuper(Occuper occuper) {
		try {
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(occuper);
			trans.commit();
		    session.close();
		    System.out.println("supprimé...");
		
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateDataOccuper(Occuper occuper) {
	
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.update(occuper);
			trans.commit();
		    session.close();
		    System.out.println("modifié...");
	
	}
		
}
