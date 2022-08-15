package com.gestionClasse.data;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
	
	private SessionFactory sessionfactory = null;
	
	public SessionFactory getSessionFactory() {
		
			
	    if(this.sessionfactory == null) {
	    	
	    	Configuration conf = new Configuration(); 
			conf.configure("hibernate.cfg.xml");
			this.sessionfactory = conf.buildSessionFactory();
		    sessionfactory.close();
	    }
			
		return this.sessionfactory;
	}
}
