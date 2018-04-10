package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.romain.easyfood.DTO.Resto;

public class RestaurantDAO {

    private BdSQLiteOpenHelper accessBD;

    public RestaurantDAO(Context ct){ accessBD = new BdSQLiteOpenHelper(ct); }

    /**
    * Retourne un curseur de tous les restaurants
    */
    public Cursor getTousLesRestaurants(){
        SQLiteDatabase bd = accessBD.getReadableDatabase();
        Cursor curseur = bd.rawQuery("SELECT * FROM RESTO", null);
        return curseur;
    }

    public Resto getRestoById(int idResto){
        SQLiteDatabase bd = accessBD.getReadableDatabase();
        String sql = "SELECT * FROM Resto WHERE idR = ?;";
        Cursor cursor = bd.rawQuery(sql, new String[] {String.valueOf(idResto)});

        cursor.moveToFirst();
        int idR = cursor.getInt(0);
        String nomR = cursor.getString(1);
        int numAdrR = cursor.getInt(2);
        String rueAdr = cursor.getString(3);
        int cpR = cursor.getInt(4);
        String villeR = cursor.getString(5);
        String idRestaurateur = cursor.getString(6);

        Resto resto = new Resto(idR, nomR, numAdrR, rueAdr, cpR, villeR, idRestaurateur);

        return resto;
    }


}
