package com.example.romain.easyfood.DAO;

import android.content.Context;

public class ContenirDAO {
    private static BdSQLiteOpenHelper accessBD;

    public ContenirDAO(Context ct){ accessBD = new BdSQLiteOpenHelper(ct);}


}
