package com.example.romain.easyfood;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.romain.easyfood.DAO.RestaurantDAO;
import com.example.romain.easyfood.DTO.Resto;
import com.example.romain.easyfood.DTO.Restos;

import java.util.ArrayList;
import java.util.LinkedList;

public class EspaceModerateur extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_moderateur);

        final RestaurantDAO restaurantAccess = new RestaurantDAO(this);
        final Restos lesRestaurants = new Restos();
        final LinkedList<String> item = new LinkedList<String>();
        ArrayList<String> StrRestos = new ArrayList<String>();

        final ListView listeRestos = (ListView) findViewById(R.id.listView_listeRestaurants);


        Cursor cursor = restaurantAccess.getTousLesRestaurants();
        lesRestaurants.setRestos(cursor);
        for(Resto resto : lesRestaurants.getRestos()){
            StrRestos.add(String.valueOf(resto.getNomR()));
            item.add(String.valueOf(resto.getIdR()));
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(EspaceModerateur.this , android.R.layout.simple_list_item_1, StrRestos);
        listeRestos.setAdapter(arrayAdapter);


        listeRestos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EspaceModerateur.this, DetailsResto.class);
                intent.putExtra("leResto", item.get(i));
                startActivity(intent);
            }
        });
    }
}
