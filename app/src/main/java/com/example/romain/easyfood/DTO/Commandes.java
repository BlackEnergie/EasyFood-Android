package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;

import com.example.romain.easyfood.DAO.CommandeDAO;


public class Commandes {
    ArrayList<Commande> Commandes ;

    public ArrayList<Commande> getCommandes() {
        return Commandes;
    }

    public void setCommandes(Cursor curseur){
        ArrayList<Commande> listeCommande = new ArrayList<Commande>();
        int idC;
        String dateC ;
        String commentaireClientC ;
        String dateLivrC ;
        String modeReglementC;
        String IdClientC ;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idC = curseur.getInt(0);
            dateC = curseur.getString(1);
            commentaireClientC = curseur.getString(2);
            dateLivrC = curseur.getString(3);
            modeReglementC = curseur.getString(4);
            IdClientC = curseur.getString(5) ;

            listeCommande.add(new Commande(idC,dateC,commentaireClientC,dateLivrC,modeReglementC,IdClientC));
            curseur.moveToNext();
        }
        Commandes = listeCommande;
    }


    public Commande rechercheCommande(int unIdCommande ){
        for (Commande Commande: Commandes){
            if (Commande.getIdC() == unIdCommande){
                return Commande;
            }
        }
        return null;
    }

    public Integer getNbCommandes(){
        return Commandes.size();
    }

    public Commande getCommande(Integer unIndex){
        return Commandes.get(unIndex);
    }

    public void ajouterCommande(Commande unCommande){
        Commandes.add(unCommande);
    }
}