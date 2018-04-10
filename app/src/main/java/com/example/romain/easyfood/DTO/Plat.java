package com.example.romain.easyfood.DTO;

public class Plat {
	private int idP;
	private int idResto;
    private int typePlat;
	private String nomP;
	private String prixFournisseurP;
	private String prixClientP;
	private String platVisible;
	private String photoP;
	private String descriptionP;


    public Plat ( int pidP, int pidResto, int ptypePlat, String pnomP,String pprixFournisseurP,String pprixClientP, String pplatVisible,String pphotoP,String pdescriptionP ) {
        this.idP = pidP;
        this.idResto = pidResto;
        this.typePlat = ptypePlat;
        this.nomP= pnomP;
        this.prixFournisseurP=pprixFournisseurP;
        this.prixClientP= pprixClientP;
        this.platVisible=pplatVisible;
        this.photoP = pphotoP;
        this.descriptionP = pdescriptionP;

    }

    public int getIdP() {
        return idP;
    }

    public void setidP(int idP) {
        this.idP = idP;
    }
    public String getNomP() {
        return nomP;
    }

    public void setnomP(String nomP) {
        this.nomP = nomP;
    }
    public String getprixFournisseurP() {
        return prixFournisseurP;
    }

    public void setprixFournisseurP(String prixFournisseurP) {
        this.prixFournisseurP = prixFournisseurP;
    }
    public String getprixClientP() {
        return prixClientP;
    }

    public void setprixClientP(String prixClientP) {
        this.prixClientP = prixClientP;
    }
    public String getplatVisible() {
        return platVisible;
    }

    public void setplatVisible(String platVisible) {
        this.platVisible = platVisible;
    }
    public String getphotoP() {
        return photoP;
    }

    public void setphotoP(String photoP) {
        this.photoP = photoP;
    }
    public String getdescriptionP() {
        return descriptionP;
    }

    public void setdescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }
    public int gettypePlat() {
        return typePlat;
    }

    public void settypePlat(int ptypePlat) {
        this.typePlat = ptypePlat;
    }
    public int getidResto() {
        return idResto;
    }

    public void setidResto(int pidResto) {
        this.idResto = pidResto;
    }
	
}
