package com.gestionClasse.data;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import com.gestionClasse.model.Prof;


public class Profdata {
	
	public void insertDataProf(Prof prof) {
	
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.save(prof);
			trans.commit();
		    session.close();
		    System.out.println("Prof ajouté...");
	
	}
	
	public List<Prof>  getAllProf(){
		
		 List<Prof> ProfModel = new ArrayList<>();
		 Config conf = new Config();
		 Session session= conf.getSessionFactory().openSession();
		 Transaction trans = session.beginTransaction();
		 
		 Query query =  session.createQuery("FROM Prof");
		 ProfModel = query.list();
		 
	     trans.commit();
		 session.close();
		 
		 return ProfModel;
	}
	
	public Prof getProf(String codeprof){
				
		  String query = "FROM Prof prof WHERE prof.codeprof="+codeprof;
				
		  Config conf = new Config();
		  Session session= conf.getSessionFactory().openSession();
		  Transaction trans = session.beginTransaction();
				
		   Query query2 = session.createQuery(query);
				
		   Prof prof=new Prof();
				
		   prof = (Prof)query2.list().get(0);
		   
		   trans.commit();
		   session.close();
						
	      return prof;
		}

	
	public void deleteDataProf(Prof prof) {
		try {
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(prof);
			trans.commit();
		    session.close();
		    System.out.println("Prof supprimé...");
		
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateDataProf(Prof prof) {
	
			
			Config conf = new Config();
			Session session= conf.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.update(prof);
			trans.commit();
		    session.close();
		    System.out.println("Prof modifié...");
		
		
		
	}
	public List<Prof> getProfByName(String nom){
		
		  String query = "FROM Prof prof WHERE prof.nom LIKE '%"+ nom + "%' ";
		  
		  List<Prof> ProfModel = new ArrayList<>();
				
		  Config conf = new Config();
		  Session session= conf.getSessionFactory().openSession();
		  Transaction trans = session.beginTransaction();
				
		   Query query2 = session.createQuery(query);
		   		
		   ProfModel = query2.list();
		   
		   trans.commit();
		   session.close();
						
	      return ProfModel;
	}
	public List<Prof> getProfByCodeProf(String codeprof){
		
		  String query = "FROM Prof prof WHERE prof.codeprof LIKE '%"+ codeprof + "%'";
		  
		  List<Prof> ProfModel = new ArrayList<>();
				
		  Config conf = new Config();
		  Session session= conf.getSessionFactory().openSession();
		  Transaction trans = session.beginTransaction();
				
		   Query query2 = session.createQuery(query);
		   		
		   ProfModel = query2.list();
		   
		   trans.commit();
		   session.close();
						
	      return ProfModel;
	}


}
