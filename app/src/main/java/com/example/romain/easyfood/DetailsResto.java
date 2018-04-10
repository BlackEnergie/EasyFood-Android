package com.example.romain.easyfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.romain.easyfood.DAO.RestaurantDAO;
import com.example.romain.easyfood.DTO.Resto;

public class DetailsResto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_resto);

        Intent intent = getIntent();
        final String strResto = intent.getStringExtra("leResto");
        int idResto = Integer.parseInt(strResto);

        RestaurantDAO RestoAccess = new RestaurantDAO(this);
        Resto leResto = RestoAccess.getRestoById(idResto);
        setTitle(leResto.getNomR());

    }
}
