/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijani.donuts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

/**
 *
 * @author vijani
 */
public class OwlReaderUtil {

    public static List<String> executeQueryOneColumn(ServletContext context, String queryString) {
        List<String> values = new ArrayList<>();
        Model model = FileManager.get().loadModel(context.getRealPath("/") + "/resources/doughnut.owl");

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = qexec.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();

                Resource x = solution.getResource("x");
                values.add(x.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return values;

    }

    public static List<List<String>> executeQueryTwoColumn(ServletContext context, String queryString) {
        List<List<String>> rows = new ArrayList();
        Model model = FileManager.get().loadModel(context.getRealPath("/") + "/resources/doughnut.owl");

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = qexec.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();

                Resource x = solution.getResource("x");
                Literal y = solution.getLiteral("y");

                List<String> column1 = Arrays.asList(x.getLocalName(), y.getInt() + "");
                rows.add(column1);
            }
        } finally {
            qexec.close();
        }
        return rows;

    }
}
