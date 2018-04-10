package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper{
    private static final int versionBD =1;
    private static final String  nomBD = "easyfood.db";

    private String requeteClient="create table Client(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteClientDrop ="drop table if exists Client;";

    private String requeteRestaurateur="create table Restaurateur(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteRestaurateurDrop ="drop table if exists Restaurateur;";

    private String requeteModerateur="create table Moderateur(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteModerateurDrop ="drop table if exists Moderateur;";

    private String requeteResto ="create table Resto(idR INTEGER PRIMARY KEY , nomR TEXT, numAdrR INTEGER,rueAdrR TEXT, cpR INTEGER, villeR TEXT, mailU TEXT, FOREIGN KEY (mailU) REFERENCES Restaurateur(mailU));";
    private String requeteRestoDrop ="drop table if exists Resto;";

    private String requeteTypePlat ="create table TypePlat(idTP INTEGER PRIMARY KEY , libelleTP TEXT NOT NULL);";
    private String requeteTypePlatDrop ="drop table if exists TypePlat;";

    private String requetePlat ="create table Plat (idP INTEGER PRIMARY KEY ,idR INTEGER, idTP INTERGER, nomP TEXT NOT NULL, prixFournisseurP INTEGER, prixClientP INTEGER, platVisible BOOLEAN,photoP TEXT, descriptionP TEXT, FOREIGN KEY (idR) REFERENCES Resto(idR), FOREIGN KEY (idTP) REFERENCES TypePlat(idTP));";
    private String requetePlatDrop ="drop table if exists Plat;";

    private String requeteCommande ="create table Commande(idC INTEGER PRIMARY KEY , dateC TEXT, commentaireClientC TEXT, dateLivrC TEXT, modeReglementC TEXT, mailU TEXT, FOREIGN KEY (mailU) REFERENCES Client(mailU));";
    private String requeteCommandeDrop ="drop table if exists Commande;";

    private String requeteContenir="create table Contenir(idP Integer, idC Integer, qtteComm Integer, commentaire TEXT, commentaireVisible boolean, PRIMARY KEY(idP,idC), FOREIGN KEY(idP)REFERENCES Plat (idP), FOREIGN KEY(idC) REFERENCES Commande (idC));";
    private String requeteContenirDrop ="drop table if exists Contenir;";

    private String requeteEvaluer = "create table Evaluer(idR INTEGER, mailU TEXT,respectRecette real, esthetiquePlat real , cout INTEGER, qualiteNourriture real, PRIMARY KEY(mailU, idR),FOREIGN KEY (mailU) REFERENCES Client(mailU), FOREIGN KEY (idR) REFERENCES Resto(idR));";
    private String requeteEvaluerDrop ="drop table if exists Evaluer;";


    public BdSQLiteOpenHelper(Context context){
        super(context, nomBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db ){
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);

        db.execSQL(requeteCommande);
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(1,'12/01/2018','Repas parfait','12/01/2018','Chèque','Client1@gmail.com');");
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(2,'18/03/2018','Juste Passable','18/03/2018','Carte Bancaire','Client2@gmail.com');");
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(3,'24/03/2018','Je ne recommande pas','24/03/2018','Especes','Client1@gmail.com');");

        db.execSQL(requeteClient);
        db.execSQL("insert into Client(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Client1@gmail.com','Tyler','Durden','Tyler',5,'rue de la Paix',33000,'Bordeaux','test');");
        db.execSQL("insert into Client(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Client2@gmail.com','Mario','Bros','Mario',14,'boulevard LaFaillette de la paix',24000,'Périgueux','test');");

        db.execSQL(requeteRestaurateur);
        db.execSQL("insert into Restaurateur(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Restaurateur1@gmail.com','Mario','Bros','Mario',14,'boulevard LaFaillette de la paix',24000,'Périgueux','test');");

        db.execSQL(requeteModerateur);
        db.execSQL("insert into Moderateur(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('modal@gmail.com','Theo','Perrin','Theo',8,'rue des Alauadettes',33000,'Bordeaux','test');");

        db.execSQL(requeteResto);
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (1, 'Le Bien Bon', 15,'rue des beaux arts',33000,'Bordeaux','Restaurateur1@gmail.com');");
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (2, 'Nom d une crêpe', 16,'rue saint remy',33000,'Bordeaux','Restaurateur1@gmail.com');");
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (3, 'Le Quatrième Mur', 2,'rue du Grand Théâtre',33000,'Bordeaux','Restaurateur1@gmail.com');");
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (4, 'Fuxia', 8,'avenue Quinconces',33000,'Bordeaux','Restaurateur1@gmail.com');");
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (5, 'Le Bistrot Bordelais', 23,'rue saint remy',33000,'Bordeaux','Restaurateur1@gmail.com');");
        db.execSQL("insert into Resto(idR , nomR , numAdrR ,rueAdrR , cpR , villeR , mailU) values (6, 'Taj Mahal', 24,'rue Parlement Sainte-Catherine',33000,'Bordeaux','Restaurateur1@gmail.com');");


        db.execSQL(requeteTypePlat);
        db.execSQL("INSERT INTO TypePlat (idTP, libelleTP) VALUES "+
                "(1, 'Entrées'),"+
                "(2, 'Plats'),"+
                "(3, 'Desserts'),"+
                "(4, 'Boissons'),"+
                "(5, 'Sauces');");

        db.execSQL(requetePlat);
        db.execSQL("insert into Plat(idP,idR, idTP, nomP , prixFournisseurP , prixClientP , platVisible ,photoP , descriptionP ) values" +
                "(1, 1, 1, 'Verrines au légumes', '6.00', '7.50', 1, 'verrineLegume', 'Avocat, jus de citron, crevette, mayonnaise, condiments')," +
                "(2, 1, 1, 'Tortilla asperge', '7.00', '11.00', 1, 'tortillaAsperge', 'Asperge, menthe, oeuf, fromage brebis, piment d espelette')," +
                "(3, 1, 1, 'Tartare au cabillot', '15.00', '22.50', 1, 'tartareCabillaud', 'Cabillot, fromage')," +
                "(4, 1, 1, 'Salade de chèvre chaud', '6.50', '8.50', 1, 'saladeChevre', 'Chèvre, pain, salade,miel')," +
                "(5, 1, 1, 'Soupe de brocolit', '3.50', '5.00', 1, 'soupeBrocolis', 'Brocolit, lait, croutons')," +
                "(6, 1, 1, 'Galette de crabes', '8.60', '11.40', 1, 'galetteCrabe', 'Crabe, oignon, persil, oeuf, piment')," +
                "(7, 1, 1, 'Oeuf Mimosas', '4.20', '6.40', 1, 'oeufMimosas', 'Oeuf, mayonnaise, siboulette')," +
                "(8, 1, 3, 'Tiramisu', '5.20', '6.90', 1, 'tiramisu', 'Fraise, fromage blanc, mascarpone, pourdre de chocolat')," +
                "(9, 1, 3, 'Galette des rois', '8.20', '11.90', 1, 'galetteRois', 'Oeuf, beurre, vanille, lait ')," +
                "(10,1,3, 'Fondant au chocolat', '4.20', '5.90', 1, 'fondantChocolat', 'Chocolat, oeuf, beurre')," +
                "(11,1,3, 'Beignet', '1.20', '3.90', 1, 'beignet', 'Farine, sucre en poudre, oeuf')," +
                "(12,1,3, 'Chouquette', '2.10', '4.80', 1, 'chouquette', 'Farine, sucre en poudre, blanc oeuf')," +
                "(13,1,3, 'Cannelés', '2.20', '3.50', 1, 'canneles', 'Vanille, rhum, morceaux de sucre')," +
                "(14,1,3, 'Crêpes', '1.20', '1.90', 1, 'crepes', 'Lait, oeuf, ricard ou fleur d oranger')," +
                "(15,1,3, 'Brownies', '3.20', '5.30', 1, 'brownies', 'Chocolat, oeuf, beurre, noix')," +
                "(16,1,3, 'Gauffres', '2.20', '3.70', 1, 'gauffres', 'Lait, oeuf, levure, fleur d oranger')," +
                "(17,1,3, 'Cookies', '3.20', '5.90', 1, 'cookies', 'Beurre, chololat, farine')," +
                "(18,1,3, 'Muffins', '5.20', '6.50', 1, 'muffins', 'Sucre, oeuf, beurre, farine, levure, framboise')," +
                "(19,1,3, 'Flan coco', '8.20', '11.90', 1, 'flanCoco', 'Oeuf, noix de coco, lait')," +
                "(20,1,3, 'Tarte aux abricots', '10.20', '13.80', 1, 'tarteAbricot', 'Pate sablée, abricot, sucre')," +
                "(21,1,3, 'Clafoutis aux cerises', '11.20', '14.90', 1, 'clafoutisCerises', 'Cerise, oeuf, lait')," +
                "(22,1,4, 'Fanta', '2.50', '3.50', 1, 'fanta', '')," +
                "(23,1,4, 'Coca Cola', '2.50', '3.50', 1, 'coca', '')," +
                "(24,1,4, 'Sprit', '2.50', '3.50', 1, 'sprit', '')," +
                "(25,1,4, 'Oasis', '2.50', '3.50', 1, 'oasis', '')," +
                "(26,1,4, 'Ice Tea', '2.50', '3.50', 1, 'icetea', '')," +
                "(27,1,4, 'St Joseph', '28.50', '33.40', 1, 'stjoseph', '')," +
                "(28,1,4, 'St Emillion - Vin', '35.50', '45.50', 1, 'stemilion', '')," +
                "(29,1,4, 'Ruinard - Champagne', '50.58', '55.70', 1, 'Ruinard', '')," +
                "(30,1,4, 'Eau', '2.70', '2.85', 1, 'eau', '')," +
                "(31,1,4, 'Café', '2.70', '2.85', 1, 'cafe', '');");



        db.execSQL(requeteContenir);
        db.execSQL("INSERT INTO Contenir (idP,idC, qtteComm, commentaire,commentaireVisible ) VALUES "+
                "(1, 1, 2,'',0 ),"+
                "(5, 1, 4,'Juste cuit',0 ),"+
                "(9, 1, 1,'Fondant',0 ),"+
                "(20, 1, 1,'Excelent',0 ),"+
                "(16, 1, 1,'Passable',0 ),"+
                "(25, 1, 8,'Delicieux',0 );");

        db.execSQL(requeteEvaluer);

        Log.d("Test", "Passage dans onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.d("Test", "Passage dans onUpgrade");
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("Test", "Passage dans onDowgrade");
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);
        onCreate(db);
    }


}
