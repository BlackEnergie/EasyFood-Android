package com.example.romain.easyfood.DTO;

import android.database.Cursor;

import java.util.ArrayList;

public class Restos {
    private ArrayList<Resto> Restos;

    public ArrayList<Resto> getRestos() { return Restos; }

    public void setRestos(Cursor curseur){
        ArrayList<Resto> lesRestos = new ArrayList<Resto>();
        int idR;
        String nomR;
        int numAdrR;
        String rueAdr;
        int cpR;
        String villeR;
        String mailU;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idR = curseur.getInt(0);
            nomR = curseur.getString(1);
            numAdrR = curseur.getInt(2);
            rueAdr = curseur.getString(3);
            cpR = curseur.getInt(4);
            villeR = curseur.getString(5);
            mailU = curseur.getString(6);

            lesRestos.add(new Resto(idR, nomR, numAdrR, rueAdr, cpR, villeR, mailU));
            curseur.moveToNext();
        }
        Restos = lesRestos;

    }
}
