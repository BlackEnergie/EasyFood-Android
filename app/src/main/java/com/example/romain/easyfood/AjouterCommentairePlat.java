package com.example.romain.easyfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.romain.easyfood.DAO.CommandeDAO;

public class AjouterCommentairePlat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commentaire_plat);

        /**####################*/
        /**Declaration variable de connexion/arraylist/msgbox*/
        /**####################*/
        final CommandeDAO commandeAcess = new CommandeDAO(this);
        final Button btnAj = (Button) findViewById(R.id.btnValider);
        final TextView txtCom = (TextView) findViewById(R.id.txtCom);

        /**####################*/
        /**Récupération des infos envoyé depuis le detailplat*/
        /**####################*/
        Intent intent = getIntent();
        final String monIdPlat = intent.getStringExtra("monIdPlat");
        final String monIdCom = intent.getStringExtra("monIdCommande");

        btnAj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterCommentairePlat.this, DetailsPlat.class);
                commandeAcess.AjouterCommentairePlat(monIdPlat, monIdCom, txtCom.getText().toString());
                startActivity(intent);
            }
        });
    }
}

