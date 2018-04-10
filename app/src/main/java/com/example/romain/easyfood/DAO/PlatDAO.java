package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PlatDAO {

    private BdSQLiteOpenHelper accessBD;

    public PlatDAO(Context ct){ accessBD = new BdSQLiteOpenHelper(ct); }

    public Cursor getTousLesPlats(){
        SQLiteDatabase bd = accessBD.getReadableDatabase();
        Cursor curseur = bd.rawQuery("SELECT * FROM PLAT", null);
        return curseur;
    }

}
