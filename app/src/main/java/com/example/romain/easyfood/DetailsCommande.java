package com.example.romain.easyfood;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.romain.easyfood.DAO.CommandeDAO;
import com.example.romain.easyfood.DAO.PlatDAO;
import com.example.romain.easyfood.DTO.Commande;
import com.example.romain.easyfood.DTO.Commandes;
import com.example.romain.easyfood.DTO.Contenir;
import com.example.romain.easyfood.DTO.Contenirs;
import com.example.romain.easyfood.DTO.Plat;
import com.example.romain.easyfood.DTO.Plats;

import java.util.ArrayList;
import java.util.LinkedList;

public class DetailsCommande extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_commande);

        /**####################*/
        /**Declaration variable de connexion/arraylist/msgbox*/
        /**####################*/
        final CommandeDAO commandeAcess = new CommandeDAO(this);
        final PlatDAO platAcess = new PlatDAO(this);
        final Commandes lesCommandes = new Commandes();
        ArrayList<String> mesCommandes = new  ArrayList<String>();

        final Contenirs lesContenirs = new Contenirs();
        ArrayList<String> mesContenirs = new  ArrayList<String>();

        final Plats lesPlats = new Plats();
        ArrayList<String> mesPlats = new  ArrayList<String>();

        final LinkedList<String> item = new LinkedList<String>();
        final LinkedList<String> item2 = new LinkedList<String>();

        /**####################*/
        /**identification listview de l'activity*/
        /**####################*/
        final ListView listePlats = (ListView) findViewById(R.id.listView_listePlat);

        /**####################*/
        /**Récupération de l'id commande client envoyé depuis le ListeCommande*/
        /**####################*/
        Intent intent = getIntent();
        final String monIdCom = intent.getStringExtra("maCommandeClient");

        /**####################*/
        /**On identifie grace à son id la commande selectionnée*/
        /**####################*/
        Cursor curseur = commandeAcess.getToutesLesCommandes();
        lesCommandes.setCommandes(curseur);
        Commande maCommande = lesCommandes.rechercheCommande(Integer.parseInt(monIdCom));


        /**####################*/
        /**On affecte et affiche les valeurs de la commande selectionnée */
        /**####################*/
        TextView numComm = (TextView) findViewById(R.id.numCom);
        numComm.setText(String.valueOf(maCommande.getIdC()));
        TextView dateComm = (TextView) findViewById(R.id.dateCommande);
        dateComm.setText(String.valueOf(maCommande.getDateC()));
        TextView dateLivr = (TextView) findViewById(R.id.dateLivrCommande);
        dateLivr.setText(String.valueOf(maCommande.getDateLivrC()));
        TextView comment = (TextView) findViewById(R.id.commentaireClient);
        comment.setText(String.valueOf(maCommande.getCommentaireClientC()));
        TextView modeRegl = (TextView) findViewById(R.id.modeReglement);
        modeRegl.setText(String.valueOf(maCommande.getModeReglementC()));

        /**####################*/
        /**on Recupere les plats et on les ajoute a la liste*/
        /**####################*/
        curseur = commandeAcess.getLesPlatsCommandesClient(monIdCom);
        lesContenirs.setContenirs(curseur);
        curseur = platAcess.getTousLesPlats();
        lesPlats.setPlats(curseur);

        for(Contenir unContenir : lesContenirs.getContenirs()){
            for(Plat unPlat : lesPlats.getPlats()) {
                if (unContenir.getidplat() == unPlat.getIdP()){
                    mesPlats.add("Plat N°" + String.valueOf(unPlat.getIdP()) + " - " + String.valueOf(unPlat.getNomP()));
                    item.add(String.valueOf(unPlat.getIdP()));
                    item2.add(String.valueOf(unContenir.getCommentaire()));
                }
            }
        }

        /**####################*/
        /**On ajoute les plats a la listeview*/
        /**####################*/
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DetailsCommande.this,android.R.layout.simple_list_item_1, mesPlats);
        listePlats.setAdapter(arrayAdapter);

        /**####################*/
        /**On identifie l'element sur lequel on a cliqué et on l'envoie lors du changement de fenêtre */
        /**####################*/
        listePlats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DetailsCommande.this, DetailsPlat.class);
                intent.putExtra("monIdPlat", item.get(position) );
                intent.putExtra("monIdCommande",monIdCom );
                intent.putExtra("monComPlat", item2.get(position) );
                startActivity(intent);
            }
        });
    }
}
