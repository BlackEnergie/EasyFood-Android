package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;


public class Plats {
    private ArrayList<Plat> Plats ;

    public ArrayList<Plat> getPlats() {
        return Plats;
    }

    public Plat recherchePlat(int unIdPlat ){
        for (Plat Plat: Plats){
            if (Plat.getIdP() == unIdPlat){
                return Plat;
            }
        }
        return null;
    }

    public void setPlats(Cursor curseur){
        ArrayList<Plat> listePlat = new ArrayList<Plat>();
        int idP;
        int idResto;
        int typePlat;
        String nomP;
        String prixFournisseurP;
        String prixClientP;
        String platVisible;
        String photoP;
        String descriptionP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idP = curseur.getInt(0);
            idResto = curseur.getInt(1);
            typePlat = curseur.getInt(2);
            nomP = curseur.getString(3);
            prixFournisseurP = curseur.getString(4);
            prixClientP = curseur.getString(5);
            platVisible = curseur.getString(6);
            photoP = curseur.getString(7);
            descriptionP = curseur.getString(8);


            listePlat.add(new Plat(idP,idResto,typePlat,nomP,prixFournisseurP,prixClientP,platVisible,photoP,descriptionP));
            curseur.moveToNext();
        }
        Plats = listePlat;
    }


    public Integer getNbPlats(){
        return Plats.size();
    }

    public Plat getPlat(Integer unIndex){
        return Plats.get(unIndex);
    }

    public void ajouterPlat(Plat unPlat){
        Plats.add(unPlat);
    }
}