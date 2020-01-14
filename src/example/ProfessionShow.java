package example;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import net.rootdev.jenajung.JenaJungGraph;
import net.rootdev.jenajung.Transformers;
import net.rootdev.jenajung.examples.ToImage;
import org.apache.commons.collections15.Transformer;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.path.Path;
import org.apache.jena.util.FileManager;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="ProfessionShow", urlPatterns={"/professionShow"})
public class ProfessionShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getRequestDispatcher("professionShow.jsp").forward(request, response);
    }

}
