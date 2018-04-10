package com.example.romain.easyfood.DTO;
public class TypePlat {
	
	private String idTP ;
	private String libelleTP ;
	
	
	public TypePlat (String pidTP, String plibelleTP) {
		this.idTP = pidTP;
		this.libelleTP = plibelleTP;
	}
	
	public String getLibelleTP() {
		return libelleTP;
	}
	public void setLibelleTP(String libelleTP) {
		this.libelleTP = libelleTP;
	}
	public String getIdTP() {
		return idTP;
	}
	public void setIdTP(String idTP) {
		this.idTP = idTP;
	}
	
	
		
}
