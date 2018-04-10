package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;


public class Contenirs {
    private ArrayList<Contenir> Contenirs ;

    public ArrayList<Contenir> getContenirs() {
        return Contenirs;
    }

    public void setContenirs(Cursor curseur){
        ArrayList<Contenir> listeContenir = new ArrayList<Contenir>();
        int idP;
        int idC;
        int qte;
        String com;
        int comV;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idP = curseur.getInt(0);
            idC = curseur.getInt(1);
            qte = curseur.getInt(2);
            com = curseur.getString(3);
            comV = curseur.getInt(4);

           listeContenir.add(new Contenir(idP,idC,qte,com,comV));
            curseur.moveToNext();
        }
        Contenirs = listeContenir;
    }


    public Integer getNbContenirs(){
        return Contenirs.size();
    }

    public Contenir getContenir(Integer unIndex){
        return Contenirs.get(unIndex);
    }

    public void ajouterContenir(Contenir unContenir){
        Contenirs.add(unContenir);
    }
}