package com.gestionClasse.model;


import java.io.Serializable;
import java.sql.Date;



public class Occuper implements Serializable {

	

	private static final long serialVersionUID = 1L;
	
	
	private String codeprof;
    private String codesalle;
    private Date thedate;
    
	public String getCodeprof() {
		return codeprof;
	}
	public void setCodeprof(String codeprof) {
		this.codeprof = codeprof;
	}
	public String getCodesalle() {
		return codesalle;
	}
	public void setCodesalle(String codesalle) {
		this.codesalle = codesalle;
	}
	public Date getThedate() {
		return thedate;
	}
	public void setThedate(Date thedate) {
		this.thedate = thedate;
	}
    
    	
}





