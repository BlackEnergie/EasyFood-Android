package com.example.romain.easyfood.DTO;

import java.util.ArrayList;

import android.database.Cursor;

import com.example.romain.easyfood.DTO.Client;


public class Clients {
    private ArrayList<Client> Clients ;

    public ArrayList<Client> getClients() {
        return Clients;
    }

    public Client rechercheClient(String unIdClient ){
        for (Client Client: Clients){
            if (Client.getMailU() == unIdClient){
                return Client;
            }
        }
        return null;
    }

    public void setClients(Cursor curseur){
        ArrayList<Client> listeClient = new ArrayList<Client>();
        String mailU;
        String pseudoU;
        String nomU;
        String prenomU;
        String numAdrU;
        String nomAdrU;
        String cpU;
        String villeU;
        String mdpU;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            mailU = curseur.getString(0);
            pseudoU = curseur.getString(1);
            nomU = curseur.getString(2);
            prenomU = curseur.getString(3);
            numAdrU = curseur.getString(4);
            nomAdrU = curseur.getString(5);
            cpU = curseur.getString(6);
            villeU = curseur.getString(7);
            mdpU = curseur.getString(8);


            listeClient.add(new Client(mailU  , pseudoU , nomU , prenomU ,numAdrU , nomAdrU , cpU , villeU , mdpU ));
            curseur.moveToNext();
        }
        Clients = listeClient;
    }


    public Integer getNbClients(){
        return Clients.size();
    }

    public Client getClient(Integer unIndex){
        return Clients.get(unIndex);
    }

    public void ajouterClient(Client unClient){
        Clients.add(unClient);
    }
}