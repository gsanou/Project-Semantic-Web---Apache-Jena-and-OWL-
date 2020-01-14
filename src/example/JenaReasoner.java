package example;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.RDF;

import java.util.Iterator;

public class JenaReasoner {


    public static void printStatements(Model m, Resource s, Property p, Resource o) {
        for (StmtIterator i = m.listStatements(s, p, o); i.hasNext();) {
            Statement stmt = i.nextStatement();
            System.out.println(" - " + PrintUtil.print(stmt));
        }
    }

    public static void reasoner (){
        Model schema = FileManager.get().loadModel("/home/miruna/Documents/Project/project.owl");
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        reasoner.bindSchema(schema);

        InfModel infmodel = ModelFactory.createInfModel(reasoner, schema);


        Resource miru = infmodel.getResource("http://www.semanticweb.org/andreea/ontologies/COR#Ana");
        Resource faculty = infmodel.getResource("http://www.semanticweb.org/andreea/ontologies/COR#Faculty");

        if (infmodel.contains(miru, RDF.type, faculty)) {
            System.out.println("Ana has a faculty");
        } else {
            System.out.println("Ana not recognized");
        }
        System.out.println("miru was here3");
        Resource loth = infmodel.getResource("http://www.semanticweb.org/andreea/ontologies/COR#Mara");
        Resource elf = infmodel.getResource("http://www.semanticweb.org/andreea/ontologies/COR#Project_Manager");

        if (infmodel.contains(loth, RDF.type, elf)) {
            System.out.println("Mara is a Project Manager");
        } else {
            System.out.println("Mara is  not recognized");
        }


        ValidityReport validity = infmodel.validate();
        if (validity.isValid()) {
            System.out.println("OK");
        } else {
            System.out.println("Conflicts");
//            for (Iterator i = validity.getReports(); i.hasNext();) {
//                ValidityReport.Report report = (ValidityReport.Report) i.next();
//                System.out.println(" - " + report);
//            }
        }

    }
}
