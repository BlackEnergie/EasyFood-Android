package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.romain.easyfood.DTO.Restaurateur;

public class RestaurateurDAO {

    private BdSQLiteOpenHelper accessBD;

    public RestaurateurDAO(Context ct) { accessBD = new BdSQLiteOpenHelper(ct); }

    public Restaurateur getRestaurateurById(String unMailU){
        SQLiteDatabase bd = accessBD.getReadableDatabase();
        String sql = "SELECT * FROM RESTAURATEUR WHERE mailU = ?";
        Cursor cursor = bd.rawQuery(sql, new String[] {String.valueOf(unMailU)});

        cursor.moveToFirst();
        String mailU = cursor.getString(0);
        String pseudoU = cursor.getString(1);
        String nomU = cursor.getString(2);
        String prenomU = cursor.getString(3);
        String numAdrU = cursor.getString(4);
        String nomAdrU = cursor.getString(5);
        String cpU = cursor.getString(6);
        String villeU = cursor.getString(7);
        String mdpU = cursor.getString(8);

        Restaurateur Resto = new Restaurateur(mailU, pseudoU, nomU, prenomU, numAdrU, nomAdrU, cpU, villeU, mdpU);

        return Resto;

    }
}
