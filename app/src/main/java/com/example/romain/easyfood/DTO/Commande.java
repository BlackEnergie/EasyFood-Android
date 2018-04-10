package com.example.romain.easyfood.DTO;



public class Commande {

	private int idC ;
	private String dateC ;
	private String commentaireClientC ;
	private String dateLivrC ;
	private String modeReglementC ;
	private String unIdClient;
	
	public Commande ( int pidC, String pdateC,String pcommentaireClientC,String pdateLivrC, String pmodeReglementC,String pclient) {
		this.idC = pidC;
		this.dateC= pdateC;
		this.commentaireClientC=pcommentaireClientC;
		this.dateLivrC= pdateLivrC;
		this.modeReglementC=pmodeReglementC;
		this.unIdClient = pclient;
		
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public String getDateC() {
		return dateC;
	}

	public void setDateC(String dateC) {
		this.dateC = dateC;
	}

	public String getCommentaireClientC() {
		return commentaireClientC;
	}

	public void setCommentaireClientC(String commentaireClientC) {
		this.commentaireClientC = commentaireClientC;
	}

	public String getModeReglementC() {
		return modeReglementC;
	}

	public void setModeReglementC(String modeReglementC) {
		this.modeReglementC = modeReglementC;
	}

	public String getDateLivrC() {
		return dateLivrC;
	}

	public void setDateLivrC(String dateLivrC) {
		this.dateLivrC = dateLivrC;
	}
	public String getClient() {
		return unIdClient;
	}

	public void setClient(String leclient) {
		this.unIdClient = leclient;
	}
}
