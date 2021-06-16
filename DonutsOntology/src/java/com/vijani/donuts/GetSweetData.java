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
@WebServlet(name = "GetSweetData", urlPatterns = { "/GetSweetData"})
public class GetSweetData extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
       List<String> sweetValues = getSweetnessValues();
        
       request.setAttribute("sweetValues", sweetValues);
      
       request.getRequestDispatcher("sweet.jsp").forward(request, response);
        
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
          doGet(request, response);
    }

    private List<String> getSweetnessValues() {
        
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                +"PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                +"PREFIX doughnut: <http://www.doughnut.com/ontologies/doughnut.owl#>"
                +" "
                +"SELECT DISTINCT ?x "
                +"WHERE "
                +"{ "
                +"?x		rdfs:subClassOf 	doughnut:SweetnessValuePartition"
                +" }";
              
        return OwlReaderUtil.executeQueryOneColumn(getServletContext(), queryString);
    
    }
    
}
