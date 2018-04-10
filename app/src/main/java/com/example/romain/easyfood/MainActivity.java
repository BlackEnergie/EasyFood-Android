package com.example.romain.easyfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.romain.easyfood.DAO.BdSQLiteOpenHelper;
import com.example.romain.easyfood.DAO.ConnexionDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**####################*/
        /**Declaration variable de connexion/bouton/msgbox*/
        /**####################*/
        final BdSQLiteOpenHelper maBddConnex = new BdSQLiteOpenHelper(this);
        final ConnexionDAO connexionAcess = new ConnexionDAO(this);
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        final Button buttonConnex = (Button) findViewById(R.id.btnValider);

        /**####################*/
        /**Connexion + creation bdd*/
        /**####################*/
        SQLiteDatabase bd = maBddConnex.getWritableDatabase();
        maBddConnex.onCreate(bd);

        /**####################*/
        /**Message box d'erreur de connexion utilisateur*/
        /**####################*/
        alertDialog.setTitle("Message");
        alertDialog.setMessage("L'identifiant ou le mot de passe ne sont pas valides");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        /**####################*/
        /**Action clic sur le bouton connexion utilisateur*/
        /**####################*/
        buttonConnex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Récupération valeur textbox*/
                EditText texteId = (EditText) findViewById(R.id.txtId);
                EditText textePwd = (EditText) findViewById(R.id.txtMdp);
                String maChaine = texteId.getText().toString();
                String maChaine2 = textePwd.getText().toString();

                /**Vérification si le client a entré les bons mail + mdp*/
                if (connexionAcess.getUserClientConnex(maChaine,maChaine2)){

                    /**Changement de fenêtre et envoie de du mail utilisateur sur la nouvelle activity */
                    Intent intent = new Intent(MainActivity.this, ListeCommandeClient.class);
                    intent.putExtra("monMailUser",maChaine);
                    startActivity(intent);
                }
                else{
                    /**Sinon vérification si le restaurateur a entré les bons mail + mdp*/
                    if (connexionAcess.getUserRestaurateurConnex(maChaine,maChaine2)){

                        /**Changement de fenêtre et envoie de du mail utilisateur sur la nouvelle activity */
                        Intent intent = new Intent(MainActivity.this, EspaceConnecte.class);
                        intent.putExtra("monMailUser",maChaine);
                        startActivity(intent);
                    }
                    else{
                        /**Sinon vérification si le moderateur a entré les bons mail + mdp*/
                        if (connexionAcess.getUserModerateurConnex(maChaine,maChaine2)){

                            /**Changement de fenêtre et envoie de du mail utilisateur sur la nouvelle activity */
                            Intent intent = new Intent(MainActivity.this, EspaceModerateur.class);
                            intent.putExtra("monMailUser",maChaine);
                            startActivity(intent);
                        }
                        else{
                            /**Affichage msgbox */
                            alertDialog.show();
                        }
                    }
                }
            }
        });
    }
}
