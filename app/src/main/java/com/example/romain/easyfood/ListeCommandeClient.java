package com.example.romain.easyfood;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import com.example.romain.easyfood.DAO.CommandeDAO;
import com.example.romain.easyfood.DTO.Commande;
import com.example.romain.easyfood.DTO.Commandes;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListeCommandeClient extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_commande_client);

        /**####################*/
        /**Declaration variable de connexion/arraylist/msgbox*/
        /**####################*/
        final CommandeDAO commandeAcess = new CommandeDAO(this);
        final Commandes lesCommandes = new Commandes();
        final LinkedList<String> item = new LinkedList<String>();
        ArrayList<String> mesCommandes = new  ArrayList<String>();

        /**####################*/
        /**identification listview de l'activity*/
        /**####################*/
        final ListView listeCommandes = (ListView) findViewById(R.id.listView_listeCommande);

        /**####################*/
        /**Récupération du mail utilisateur envoyé depuis le MainActivity*/
        /**####################*/
        Intent intent = getIntent();
        String monIdClient = intent.getStringExtra("monMailUser");

        /**####################*/
        /**on Recupere les commandes et on les ajoute a la liste*/
        /**####################*/
        Cursor curseur = commandeAcess.getLesCommandesClient(monIdClient);
        lesCommandes.setCommandes(curseur);
        for(Commande unCommande : lesCommandes.getCommandes()){
            mesCommandes.add("Commande N°"+String.valueOf(unCommande.getIdC()));
            item.add(String.valueOf(unCommande.getIdC()));
        }

        /**####################*/
        /**On ajoute les commandes a la listeview*/
        /**####################*/
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListeCommandeClient.this,android.R.layout.simple_list_item_1, mesCommandes);
        listeCommandes.setAdapter(arrayAdapter);

        /**####################*/
        /**On identifie l'element sur lequel on a cliqué et on l'envoie lors du changement de fenêtre */
        /**####################*/
        listeCommandes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListeCommandeClient.this, DetailsCommande.class);
                intent.putExtra("maCommandeClient", item.get(position) );
                startActivity(intent);
            }
        });
    }
}
