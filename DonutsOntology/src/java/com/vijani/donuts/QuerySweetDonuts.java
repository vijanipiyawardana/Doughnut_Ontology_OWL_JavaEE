/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijani.donuts;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vijani
 */
@WebServlet(name = "SweetDonuts", urlPatterns = {"/SweetDonuts"})
public class QuerySweetDonuts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("sweetValue");
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                +"PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                +"PREFIX doughnut: <http://www.doughnut.com/ontologies/doughnut.owl#>"
                +" "
                +"SELECT DISTINCT ?x "
                +"WHERE "
                +"{ "
                +"?p 		rdfs:subClassOf 		?restriction."
                +"?restriction 	owl:onProperty 		doughnut:hasSweetness."
                +"?restriction 	owl:someValuesFrom 		doughnut:%s."
                +"?x		doughnut:hasTopping	?p."
                +" }"
                +"LIMIT 4";

        
        queryString = String.format(queryString, value);
        System.out.println(queryString);
        //List<List<String>> rows = OwlReaderUtil.executeQueryTwoColumn(getServletContext(), queryString);
        List<String> rows = OwlReaderUtil.executeQueryOneColumn(getServletContext(), queryString);
        request.setAttribute("results", rows);
        request.setAttribute("sweetValue",value);
        request.getRequestDispatcher("GetSweetData").forward(request, response);

    }

}
