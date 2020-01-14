package example;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@WebServlet(name="Sparql", urlPatterns={"/sparql"})
public class Sparql extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("sparql.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sparql = request.getParameter("sparql") ;
        System.out.println(sparql);
        String resource = "/home/miruna/Documents/Project/project.owl";
        String queryString = sparql;
        Query query = QueryFactory.create(queryString) ;
        Model model;
        model = FileManager.get().loadModel(resource);

        Map<String,ArrayList< String>> results = new HashMap<>();
        ArrayList<String> profession = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            int iCount = 0;
            ResultSet rs = qexec.execSelect();
            while (rs.hasNext()) {
                // Get Result
                QuerySolution qs = rs.next();

                // Get Variable Names
                Iterator<String> itVars = qs.varNames();

                // Count
                iCount++;
                System.out.println("Result " + iCount + ": ");

                // Display Result

                while (itVars.hasNext()) {
                    String szVar = itVars.next().toString();
                    String szVal = qs.get(szVar).toString();

                    System.out.println("[ var=" + szVar + "]: " + szVal);
                    if(szVar.equals("person")){
                        names.add(szVal);
                    }else{
                        profession.add(szVal);
                    }
                }

            }
        }
        results.put("names",names);
        results.put("x",profession);
        session.setAttribute("resultq7", results);

        request.getRequestDispatcher("sparqlResults.jsp").forward(request, response);

    }
}


