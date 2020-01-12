package example;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class Queries {
    public void query1(){
        String filename = "/home/miruna/Documents/Project/web/WEB-INF/project.rdf";
//        String filename = (String)session.getAttribute("filename");
        System.out.println(filename);
        String uri ="project.rdf";
        String resource = "/home/miruna/Documents/Project/web/WEB-INF/"+uri;

        Model model = FileManager.get().loadModel(resource);
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"+
                "SELECT ?job ?name \n"
                +"WHERE {?name rdf:name ?job} \n"+
                "LIMIT 100";
        Query query = QueryFactory.create(queryString) ;
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
    }
}
