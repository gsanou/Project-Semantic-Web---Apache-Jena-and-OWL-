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

@WebServlet(name="Graduate", urlPatterns={"/graduate"})
public class Graduate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String resource = "/home/miruna/Documents/Project/project.rdf";
        String queryString = "PREFIX f: <http://www.example.org/schemas/project>\n" +
                "                SELECT ?t ?x\n" +
                "                WHERE {\n" +
                "                ?t f:gradYear ?x.\n" +
                "      FILTER(?x>=\"2015\")}";
        Query query = QueryFactory.create(queryString) ;
        Model model;
        model = FileManager.get().loadModel(resource);

        Map<String,ArrayList< String>> results = new HashMap<>();
        ArrayList<String> gradYear = new ArrayList<>();
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
                    if(szVar.equals("t")){
                        names.add(szVal);
                    }else{
                        gradYear.add(szVal);
                    }
                }

            }
        }
        results.put("names",names);
        results.put("gradYear",gradYear);
        session.setAttribute("resultq2", results);
        request.getRequestDispatcher("graduate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

