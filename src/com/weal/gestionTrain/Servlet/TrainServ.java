package com.weal.gestionTrain.Servlet;

import com.weal.gestionTrain.beans.Itineraire;
import com.weal.gestionTrain.beans.Train;
import com.weal.gestionTrain.dao.implTrain.AfficherValeurAuTable;
import com.weal.gestionTrain.dao.implTrain.TrainDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/train/login","/train"})
public class TrainServ extends HttpServlet {
    Itineraire itineraire = new Itineraire();
    Train train;
    TrainDaoImpl trainDao = new TrainDaoImpl();
    AfficherValeurAuTable afficherValeurAuTable = new AfficherValeurAuTable();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getHttpServletMapping().getPattern();
        if (action.equals("/train")){
            this.listeTrain(request,response);
        }
        else if (action.equals("/train/login")){
            this.AllerAuLogin(request,response);
        }
    }

    private void AllerAuLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Train> getnumIti = getnumIti();
        String numTrain = this.numTrains();
        request.setAttribute("numTrain",numTrain);
        request.setAttribute("getNumIti",getnumIti);
        this.getServletContext().getRequestDispatcher("/Train/LoginTrain.jsp").forward(request,response);

    }


    private void listeTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Train> listTrain = afficherValeurAuTable.getTableViews();
        request.setAttribute("listeTrain",listTrain);
        this.getServletContext().getRequestDispatcher("/Train/train.jsp").forward(request,response);
    }

    private List<Train> getnumIti(){
                List<Train> numItineraire = new ArrayList<Train>();
            try {

                ResultSet load = trainDao.comboRp();
                while (load.next()){
                    train = new Train();
                    train.setNumItineraire(load.getString(1));
                    numItineraire.add(train);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return numItineraire;
    }

    private String numTrains(){
            ResultSet load = trainDao.RecuperationNumTrain();
            String numTrains = "";
        try {
            while (load.next()){
                train.setNumTrain(load.getString(1));
                int numTrain = Integer.parseInt(train.getNumTrain());
                if (numTrain <= 9){
                    numTrains = "T00"+numTrain;
                }
                else if(numTrain <= 10 || numTrain <= 99 ) {
                    numTrains = "T0"+numTrain;
                }
                else if(numTrain <= 100 || numTrain <= 999 ) {
                    numTrains = "T"+numTrain;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numTrains;
    }
}
