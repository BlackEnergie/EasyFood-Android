package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;


public class Restaurateurs {
    ArrayList<Restaurateur> Restaurateurs ;

    public ArrayList<Restaurateur> getRestaurateurs() {
        return Restaurateurs;
    }

    public Restaurateur rechercheRestaurateur(String unIdRestaurateur ){
        for (Restaurateur Restaurateur: Restaurateurs){
            if (Restaurateur.getMailU() == unIdRestaurateur){
                return Restaurateur;
            }
        }
        return null;
    }

    public void setRestaurateurs(Cursor curseur){
        ArrayList<Restaurateur> listeRestaurateur = new ArrayList<Restaurateur>();
        String mailU;
        String pseudoU;
        String nomU;
        String prenomU;
        String numAdrU;
        String nomAdrU;
        String cpU;
        String villeU;
        String mdpU;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            mailU = curseur.getString(0);
            pseudoU = curseur.getString(1);
            nomU = curseur.getString(2);
            prenomU = curseur.getString(3);
            numAdrU = curseur.getString(4);
            nomAdrU = curseur.getString(5);
            cpU = curseur.getString(6);
            villeU = curseur.getString(7);
            mdpU = curseur.getString(8);


            listeRestaurateur.add(new Restaurateur(mailU  , pseudoU , nomU , prenomU ,numAdrU , nomAdrU , cpU , villeU , mdpU ));
            curseur.moveToNext();
        }
        Restaurateurs = listeRestaurateur;
    }



    public boolean rechercheRestaurateur(Restaurateur unRestaurateur ){
        boolean result = false ;
        for (Restaurateur Restaurateur: Restaurateurs){
            if (Restaurateur.getMailU() == unRestaurateur.getMailU() ){
                result= true;
            }
        }
        return result;

    }

    public Integer getNbRestaurateurs(){
        return Restaurateurs.size();
    }

    public Restaurateur getRestaurateur(Integer unIndex){
        return Restaurateurs.get(unIndex);
    }

    public void ajouterRestaurateur(Restaurateur unRestaurateur){
        Restaurateurs.add(unRestaurateur);
    }
}