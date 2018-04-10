package com.example.romain.easyfood.DTO;

public class Contenir {

	private int idplat ;
	private int idcommande ;
	private int qteComm ;
	private String commentaire;
	private int commentaireVisible;
	
	public Contenir (int pidplat, int  pidcommande, Integer pqteComm, String pcommentaire, int pcommentaireVisible) {
		this.setplat(pidplat);
		this.setcommande(pidcommande);
		this.setQteComm(pqteComm);
		this.setCommentaire(pcommentaire);
		this.setCommentaireVisible(pcommentaireVisible);
	}

	public int getidplat() {
		return idplat;
	}

	public void setplat(int idplat) {
		this.idplat = idplat;
	}

	public int getidcommande() {
		return idcommande;
	}

	public void setcommande(int idcommande) {
		this.idcommande = idcommande;
	}

	public Integer getQteComm() {
		return qteComm;
	}

	public void setQteComm(Integer qteComm) {
		this.qteComm = qteComm;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getCommentaireVisible() {
		return commentaireVisible;
	}

	public void setCommentaireVisible(int commentaireVisible) {
		this.commentaireVisible = commentaireVisible;
	}
	
}
