package example;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout3d.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.RenderContext;
import net.rootdev.jenajung.JenaJungGraph;
import net.rootdev.jenajung.Transformers;
import org.apache.commons.collections15.Transformer;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDFS;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

@WebServlet(name="Add", urlPatterns={"/add"})
public class Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String resource = "/home/miruna/Documents/Project/project.rdf";
        String queryString = "PREFIX f: <http://www.example.org/schemas/project>\n" +
                "SELECT ?t ?a\n" +
                "WHERE { \n" +
                "?t f:company ?a \n" +
                "}";
        Query query = QueryFactory.create(queryString) ;
        Model model;
        model = FileManager.get().loadModel(resource);

        Map<String,ArrayList< String>> results = new HashMap<>();
        ArrayList<String> jobs = new ArrayList<>();
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


                    if(szVar.equals("t")){
                        names.add(szVal);
                    }else{
                        jobs.add(szVal);
                    }
                }
                System.out.println(jobs.size());
                results.put("jobs", jobs);
                results.put("names", names);
            }
        }

        session.setAttribute("result", results);

        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, ArrayList<String>> query1 = (Map<String, ArrayList<String>>) session.getAttribute("result");
        ArrayList<String> jobs = query1.get("jobs");
        ArrayList<String> names = query1.get("names");
        String resource1 = "/home/miruna/Documents/Project/project.rdf";
        Model model;
        model = FileManager.get().loadModel(resource1);
        Resource r = ResourceFactory.createResource("http://example.org#Ana_Enache");
        Property p =ResourceFactory.createProperty("http://www.example.org/schemas/projectinterest");
        model.add(r,p,"music");
        System.out.println(model);
//        for (int i = 0; i < jobs.size(); i++) {
//            try {
//                if (request.getParameter("job" + i) != null) {
//                    String a = request.getParameter("job" + i);
//                    List<String> result = new ArrayList<>();
//
//                    Property property = ResourceFactory.createProperty("@f:", "company");
//                    model.listResourcesWithProperty(property, jobs.get(i)).forEachRemaining(resource -> {
//                        result.add(resource.getLocalName());
//                    });
//                    System.out.println(model);
//                }
//
//            } catch (NullPointerException e) {
//                System.out.println(e);
//            }
// [http://example.org#Ana_Enache, http://www.example.org/schemas/projectinterest, "traveling"]>
//            }


//        }
    }

    }
