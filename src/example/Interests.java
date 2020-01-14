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

@WebServlet(name="Interests", urlPatterns={"/interests"})
public class Interests extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String professions[] = request.getParameterValues("profession") ;

        String resource = "/home/miruna/Documents/Project/project.rdf";
        String queryString ="PREFIX f: <http://www.example.org/schemas/project>\n" +
                "SELECT ?t ?x \n" +
                "WHERE { \n" +
                "?t f:interest ?x}  \n" +
                " ORDER BY ?x \n" +
                "";
        Query query = QueryFactory.create(queryString) ;
        Model model;
        model = FileManager.get().loadModel(resource);

        Map<String,ArrayList< String>> results = new HashMap<>();
        ArrayList<String> interest = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        int max = 0;
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

                        if(count.containsKey(szVal)){
                            int a = count.get(szVal)+1;
                            count.put(szVal, a);
                        }else{
                            count.put(szVal, 1);
                        }
                    }else{
                        interest.add(szVal);
                    }
                }

            }
        }
        for (Map.Entry<String,Integer> entry :count.entrySet())
        {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if(entry.getValue() > max){
                max = entry.getValue();
            }

        }
        for (Map.Entry<String,Integer> entry :count.entrySet())
        {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(entry.getValue() == max){
               names.add(entry.getKey());
            }

        }

//        results.put("names",names);
//        results.put("interests",interest);
        session.setAttribute("resultq5", names);
        System.out.println(names);
        request.getRequestDispatcher("interests.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

