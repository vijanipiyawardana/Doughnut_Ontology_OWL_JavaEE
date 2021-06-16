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
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vijani
 */
@WebServlet(name = "QueryDonuts", urlPatterns = {"/QueryDonuts"})
public class QueryDonuts extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(QueryDonuts.class);
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String base = request.getParameter("base");
        String frost = request.getParameter("frost");

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX doughnut: <http://www.doughnut.com/ontologies/doughnut.owl#>"
                + " "
                +"SELECT DISTINCT  ?x ?y "
                + "WHERE "
                + "{ "
                + "    ?x     doughnut:hasBase    doughnut:%s."
                + "    ?x     doughnut:hasFrosting    doughnut:%s."
                + "    ?x     doughnut:hasSugarContentValue ?y."
                + "}";

        queryString = String.format(queryString, base, frost);
        System.out.println(queryString);
        List<List<String>> rows  = OwlReaderUtil.executeQueryTwoColumn(getServletContext(), queryString);

        request.setAttribute("results", rows);
        request.setAttribute("base", base);
        request.setAttribute("frost", frost);
        request.getRequestDispatcher("StandardSearch").forward(request, response);
   
    }

}
