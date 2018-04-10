package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

public class Resto {
    private Integer idR;
    private String nomR;
    private Integer numAdrR;
    private String rueAdr;
    private Integer cpR;
    private String villeR;
    private String idRestaurateur;

    public Resto(Integer idR, String nomR, Integer numAdrR, String rueAdr, Integer cpR, String villeR, String idRestaurateur) {
        this.idR = idR;
        this.nomR = nomR;
        this.numAdrR = numAdrR;
        this.rueAdr = rueAdr;
        this.cpR = cpR;
        this.villeR = villeR;
        this.idRestaurateur = idRestaurateur;
    }

    public Integer getIdR() {
        return idR;
    }

    public void setIdR(Integer idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public Integer getNumAdrR() {
        return numAdrR;
    }

    public void setNumAdrR(Integer numAdrR) {
        this.numAdrR = numAdrR;
    }

    public String getRueAdr() {
        return rueAdr;
    }

    public void setRueAdr(String rueAdr) {
        this.rueAdr = rueAdr;
    }

    public Integer getCpR() {
        return cpR;
    }

    public void setCpR(Integer cpR) {
        this.cpR = cpR;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public String getIdRestaurateur() {
        return idRestaurateur;
    }

    public void setIdRestaurateur(String idRestaurateur) {
        this.idRestaurateur = idRestaurateur;
    }
}