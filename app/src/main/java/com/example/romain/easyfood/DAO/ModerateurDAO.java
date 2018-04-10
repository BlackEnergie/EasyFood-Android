package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.romain.easyfood.DTO.Moderateur;

public class ModerateurDAO {
    private static BdSQLiteOpenHelper accesBD;

    public  ModerateurDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct);
    }

    public Moderateur getByMail(String mail){
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String sql = "SELECT * FROM Moderateur WHERE mailU = ?";
        Cursor cursor = bd.rawQuery(sql, new String[] {String.valueOf(mail)});

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

        Moderateur moderateur = new Moderateur(mailU, pseudoU, nomU, prenomU, numAdrU, nomAdrU, cpU, villeU, mdpU);

        return moderateur;
    }
}
