package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;


public class Moderateurs {
    ArrayList<Moderateur> Moderateurs ;

    public ArrayList<Moderateur> getModerateurs() {
        return Moderateurs;
    }

    public Moderateur rechercheModerateur(String unIdModerateur ){
        for (Moderateur Moderateur: Moderateurs){
            if (Moderateur.getMailU() == unIdModerateur){
                return Moderateur;
            }
        }
        return null;
    }

    public void setModerateurs(Cursor curseur){
        ArrayList<Moderateur> listeModerateur = new ArrayList<Moderateur>();
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


            listeModerateur.add(new Moderateur(mailU  , pseudoU , nomU , prenomU ,numAdrU , nomAdrU , cpU , villeU , mdpU ));
            curseur.moveToNext();
        }
        Moderateurs = listeModerateur;
    }



    public boolean rechercheModerateur(Moderateur unModerateur ){
        boolean result = false ;
        for (Moderateur Moderateur: Moderateurs){
            if (Moderateur.getMailU() == unModerateur.getMailU() ){
                result= true;
            }
        }
        return result;

    }

    public Integer getNbModerateurs(){
        return Moderateurs.size();
    }

    public Moderateur getModerateur(Integer unIndex){
        return Moderateurs.get(unIndex);
    }

    public void ajouterModerateur(Moderateur unModerateur){
        Moderateurs.add(unModerateur);
    }
}