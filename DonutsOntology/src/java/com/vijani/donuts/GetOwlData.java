/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijani.donuts;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

/**
 *
 * @author vijani
 */
@WebServlet(name = "GetOwlData", urlPatterns = { "/StandardSearch"})
public class GetOwlData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        List<String> bases = getBases();
        List<String> frostings = getFrostings();
        
        request.setAttribute("bases", bases);
        request.setAttribute("frostings", frostings);
        
        request.getRequestDispatcher("page.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
        
    }

    

    private List<String> getBases() {        

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX doughnut: <http://www.doughnut.com/ontologies/doughnut.owl#>"
                + " "
                + "SELECT DISTINCT  ?x "
                + "WHERE "
                + "{"
                + "    ?d     doughnut:hasBase    ?x"
                + "}";

        return OwlReaderUtil.executeQueryOneColumn(getServletContext(), queryString);
    }
    
    private List<String> getFrostings() {        

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX doughnut: <http://www.doughnut.com/ontologies/doughnut.owl#>"
                + " "
                + "SELECT DISTINCT  ?x "
                + "WHERE "
                + "{"
                + "    ?d     doughnut:hasFrosting    ?x"
                + "}";

        return OwlReaderUtil.executeQueryOneColumn(getServletContext(), queryString);
    }
}
