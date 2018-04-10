package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.romain.easyfood.DTO.Clients;

/**
 * Created by romain on 24/03/2018.
 */

public class ConnexionDAO {
    /**####################*/
    /**Declaration variable de connexion*/
    /**####################*/
    private static BdSQLiteOpenHelper accesBD;

    public  ConnexionDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct);
    }


    /**####################*/
    /**Teste si les paramètres de connexion mail + mdp sont ceux d'un client*/
    /**####################*/
    public boolean getUserClientConnex(String unMailClient,String unPwdClient){
        Boolean result = false;
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String maRequete = "SELECT * FROM CLIENT WHERE mailU ='"+unMailClient+"' AND mdpU='"+unPwdClient+"';";
        Cursor curseur = bd.rawQuery(maRequete,null);
        if (curseur.getCount() > 0) {
            result = true;
        }
        return result;
    }

    /**####################*/
    /**Teste si les paramètres de connexion mail + mdp sont ceux d'un restaurateur*/
    /**####################*/
    public boolean getUserRestaurateurConnex(String unMailClient,String unPwdClient){
        Boolean result = false;
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String maRequete = "SELECT * FROM RESTAURATEUR WHERE mailU ='"+unMailClient+"' AND mdpU='"+unPwdClient+"';";
        Cursor curseur = bd.rawQuery(maRequete,null);
        if (curseur.getCount() > 0) {
            result = true;
        }
        return result;
    }

    /**####################*/
    /**Teste si les paramètres de connexion mail + mdp sont ceux d'un modérateur*/
    /**####################*/
    public boolean getUserModerateurConnex(String unMailClient,String unPwdClient){
        Boolean result = false;
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String maRequete = "SELECT * FROM MODERATEUR WHERE mailU ='"+unMailClient+"' AND mdpU='"+unPwdClient+"';";
        Cursor curseur = bd.rawQuery(maRequete,null);
        if (curseur.getCount() > 0) {
            result = true;
        }
        return result;
    }
}