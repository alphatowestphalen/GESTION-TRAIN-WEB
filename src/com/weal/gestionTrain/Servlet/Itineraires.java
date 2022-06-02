package com.weal.gestionTrain.Servlet;

import com.weal.gestionTrain.beans.Itineraire;
import com.weal.gestionTrain.dao.implIti.AfficherValeurAuTable;
import com.weal.gestionTrain.dao.implIti.ItinenraireDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/Itineraire","/Itineraire/login","/Itineraire/ajouter","/Itineraire/edit","/Itineraire/delet","/Itineraire/update"})
public class Itineraires extends HttpServlet {

    AfficherValeurAuTable afficherValeurAuTable = new AfficherValeurAuTable();
    ItinenraireDaoImpl itinenraireDao = new ItinenraireDaoImpl();
    Itineraire itineraire = new Itineraire();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getHttpServletMapping().getPattern();
        if (action.equals("/Itineraire/ajouter")){
            this.ajouter(request,response);
        }
        else if (action.equals("/Itineraire/update")){
            this.ajouter(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getHttpServletMapping().getPattern();

        if (action.equals("/Itineraire")){
            this.listeItineraire(request,response);
        }

        else if (action.equals("/Itineraire/login")){
            this.AllerAuLogin(request,response);
        }
        else if (action.equals("/Itineraire/edit")){
            this.ajouterValeurAuImput(request,response);
        }
        else if (action.equals("/Itineraire/delet")){
            this.delete(request,response);
        }

    }


    private void ajouterValeurAuImput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itiId   = request.getParameter("Iti");

        try {
            ResultSet load = itinenraireDao.loadTable(itiId);
            while (load.next()){
                itineraire.setId(load.getString(1));
                itineraire.setNumItineraire(load.getString(2));
                itineraire.setVilleDepart(load.getString(3));
                itineraire.setVilleArrive(load.getString(4));
                itineraire.setFrais(load.getInt(5));
                request.setAttribute("itineraire",itineraire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/Itineraire/LoginIti.jsp").forward(request,response);
    }

    private void listeItineraire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Itineraire> listeItineraire = afficherValeurAuTable.ListeIti();
        request.setAttribute("listeItineraire", listeItineraire);
        this.getServletContext().getRequestDispatcher("/Itineraire/Itineraire.jsp").forward(request,response);
    }

    private void ajouter(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String numIti   = request.getParameter("numIti");
        String villeDep = request.getParameter("villeDep");
        String villeArr   = request.getParameter("villeArr");
        String Frais   = request.getParameter("Frais");
        int frais = Integer.parseInt(Frais);
        itineraire.setId(id);
        itineraire.setNumItineraire(numIti);
        itineraire.setVilleDepart(villeDep);
        itineraire.setVilleArrive(villeArr);
        itineraire.setFrais(frais);
        if (id != null){
            itinenraireDao.Update(itineraire);
        }else {
            itinenraireDao.Insert(itineraire);
        }
        this.listeItineraire(request,response);
        response.sendRedirect("/Itineraire.jsp");
    }

    private void delete(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("Iti");
        itineraire.setId(id);
        itinenraireDao.Delete(itineraire);
        this.listeItineraire(request,response);
        this.getServletContext().getRequestDispatcher("/Itineraire/Itineraire.jsp").forward(request,response);
    }

    private void AllerAuLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                ResultSet load = itinenraireDao.RecuperationNumItineraire();
                while (load.next()){
                    itineraire.setNumItineraire(load.getString(1));
                    int numIti = Integer.parseInt(itineraire.getNumItineraire());
                    String numItis = "";
                    if (numIti <= 9){
                        numItis = "I00"+numIti;
                    }
                    else if(numIti <= 10 || numIti <= 99 ) {
                        numItis = "I0"+numIti;
                    }
                    else if(numIti <= 100 || numIti <= 999 ) {
                        numItis = "I"+numIti;
                    }
                    itineraire.setNumItineraire(numItis);
                    request.setAttribute("numItineraire",itineraire);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        this.getServletContext().getRequestDispatcher("/Itineraire/LoginIti.jsp").forward(request,response);
    }


}
