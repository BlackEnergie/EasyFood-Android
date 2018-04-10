package com.example.romain.easyfood.DTO;

public class Client {
    private  String mailU;
    private  String pseudoU;
    private  String nomU;
    private  String prenomU;
    private  String numAdrU;
    private  String nomAdrU;
    private  String cpU;
    private  String villeU;
    private  String mdpU;



    public Client (String mailU, String pseudoU, String nomU, String prenomU, String numAdrU, String nomAdrU, String cpU, String villeU, String mdpU) {
        this.mailU = mailU;
        this.pseudoU = pseudoU;
        this.nomU = nomU;
        this.prenomU = prenomU;
        this.numAdrU = numAdrU;
        this.nomAdrU = nomAdrU;
        this.cpU = cpU;
        this.villeU = villeU;
        this.mdpU = mdpU;
    }

    public void setMailU(String mailU) {
        this.mailU = mailU;
    }

    public void setPseudoU(String pseudoU) {
        this.pseudoU = pseudoU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public void setNumAdrU(String numAdrU) {
        this.numAdrU = numAdrU;
    }

    public void setNomAdrU(String nomAdrU) {
        this.nomAdrU = nomAdrU;
    }

    public void setCpU(String cpU) {
        this.cpU = cpU;
    }

    public void setVilleU(String villeU) {
        this.villeU = villeU;
    }

    public void setMdpU(String mdpU) {
        this.mdpU = mdpU;
    }

    public String getMailU() {
        return mailU;
    }

    public String getPseudoU() {
        return pseudoU;
    }

    public String getNomU() {
        return nomU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public String getNumAdrU() {
        return numAdrU;
    }

    public String getNomAdrU() {
        return nomAdrU;
    }

    public String getCpU() {
        return cpU;
    }

    public String getVilleU() {
        return villeU;
    }

    public String getMdpU() {
        return mdpU;
    }

}
