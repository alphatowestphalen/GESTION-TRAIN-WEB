package com.weal.gestionTrain.dao.implTrain;

import com.weal.gestionTrain.Db.ConnexionDB;
import com.weal.gestionTrain.beans.Itineraire;
import com.weal.gestionTrain.beans.Train;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AfficherValeurAuTable {
        private Connection connection;

        public AfficherValeurAuTable() {
            ConnexionDB connexionDB = new ConnexionDB();
            connection = connexionDB.getConnexion();
        }

        public List<Train> getTableViews() {
            List<Train> listTrain = new ArrayList<Train>();
            try {
               TrainDaoImpl trainDao = new TrainDaoImpl();
                Train train;
                Itineraire itineraire;
                ResultSet load = trainDao.loadTable();
                while (load.next()){
                    train = new Train();
                    train.setId(load.getString("id"));
                    train.setNumTrain(load.getString("NumTrain"));
                    train.setNbrPlace(load.getString("NbrPlace"));
                    train.setDesing(load.getString("Desing"));
                    train.setNumItineraire(load.getString("NumItineraire"));
                    listTrain.add(train);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listTrain;
        }



    }
