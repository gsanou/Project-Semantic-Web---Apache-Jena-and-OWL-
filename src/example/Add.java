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
import java.util.Properties;

@WebServlet(name="Add", urlPatterns={"/add"})
public class Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String resource = "/home/miruna/Documents/Project/web/WEB-INF/project.rdf";


        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"+
                "SELECT ?job ?name \n"
                +"WHERE {?name rdf:name ?job} \n"+
                "LIMIT 100";
        Query query = QueryFactory.create(queryString) ;
        System.out.println("maa");
        Model model = FileManager.get().loadModel(resource);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;
            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                RDFNode x = soln.get("varName") ;       // Get a result variable by name.
                Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
                Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
                System.out.println(x);
                System.out.println(r);
                System.out.println(l);
            }
        }
//       Queries q = new Queries();
//       q.query1();
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}
