package com.weal.gestionTrain.dao.implIti;

import com.weal.gestionTrain.Db.ConnexionDB;
import com.weal.gestionTrain.beans.Itineraire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AfficherValeurAuTable  {
    private Connection connection;

    public AfficherValeurAuTable() {
        ConnexionDB connectionDb = new ConnexionDB();
        connection = connectionDb.getConnexion();
    }

    public List<Itineraire> ListeIti() {
        List<Itineraire> ListeItineraire = new ArrayList<Itineraire>();
        try {
            ItinenraireDaoImpl itinenraireDaoImpl = new ItinenraireDaoImpl();
            Itineraire itineraire;
            ResultSet load =  itinenraireDaoImpl.loadTable();
            while (load.next()){
                itineraire = new Itineraire();
                itineraire.setId(load.getString(1));
                itineraire.setNumItineraire(load.getString(2));
                itineraire.setVilleDepart(load.getString(3));
                itineraire.setVilleArrive(load.getString(4));
                itineraire.setFrais(load.getInt(5));
                ListeItineraire.add(itineraire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListeItineraire;
    }



}
