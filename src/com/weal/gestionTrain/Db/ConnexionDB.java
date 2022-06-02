package com.weal.gestionTrain.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

    public Connection getConnexion(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ges_train","root","");
            System.out.println("connecte aus base de donner");
        } catch ( SQLException e) {
            System.out.println("Lachée votre Serveurs");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
