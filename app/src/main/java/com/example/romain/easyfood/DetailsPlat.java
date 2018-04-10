package com.example.romain.easyfood;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.example.romain.easyfood.DAO.PlatDAO;
import com.example.romain.easyfood.DTO.Plat;
import com.example.romain.easyfood.DTO.Plats;

public class DetailsPlat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_plat);
        /**####################*/
        /**Declaration variable de connexion/arraylist/msgbox*/
        /**####################*/
        final PlatDAO platAcess = new PlatDAO(this);
        final Plats lesPlats = new Plats();
        final Button btnAjouterComm = (Button) findViewById(R.id.btnAjouterComm);
        final ImageView imgCom  = (ImageView)  findViewById(R.id.imgCom);
        final TextView lblCom = (TextView)  findViewById(R.id.lblCom);

        /**####################*/
        /**Récupération des infos envoyé depuis le detailCommande*/
        /**####################*/
        Intent intent = getIntent();
        final String monIdPlat = intent.getStringExtra("monIdPlat");
        final String monIdCom = intent.getStringExtra("monIdCommande");
        final String monComPlat = intent.getStringExtra("monComPlat");

        /**####################*/
        /**On identifie grace à son id la commande selectionnée*/
        /**####################*/
        Cursor curseur = platAcess.getTousLesPlats();
        lesPlats.setPlats(curseur);
        Plat monPlat = lesPlats.recherchePlat(Integer.parseInt(monIdPlat));

        /**####################*/
        /**On affecte et affiche les valeurs de la commande selectionnée */
        /**####################*/
        TextView nomPlat = (TextView) findViewById(R.id.nomPlat);
        nomPlat.setText(String.valueOf(monPlat.getNomP()));
        TextView typePlat = (TextView) findViewById(R.id.typePlat);
        typePlat.setText(String.valueOf(monPlat.gettypePlat()));
        TextView prix = (TextView) findViewById(R.id.prix);
        prix.setText(String.valueOf(monPlat.getprixClientP())+"€");
        TextView descrip = (TextView) findViewById(R.id.description);
        descrip.setText(String.valueOf(monPlat.getdescriptionP()));

        if(monComPlat.isEmpty()){
            imgCom.setVisibility(View.INVISIBLE);
            btnAjouterComm.setVisibility(View.VISIBLE);
            lblCom.setVisibility(View.INVISIBLE);

            /**####################*/
            /**Action clic sur le bouton ajouter commentaire */
            /**####################*/
            btnAjouterComm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DetailsPlat.this, AjouterCommentairePlat.class);
                    intent.putExtra("monIdPlat", monIdPlat);
                    intent.putExtra("monIdCommande", monIdCom);
                    startActivity(intent);
                }
            });
        }
        else {
            imgCom.setVisibility(View.VISIBLE);
            btnAjouterComm.setVisibility(View.INVISIBLE);
            lblCom.setVisibility(View.VISIBLE);
        }
    }
}
