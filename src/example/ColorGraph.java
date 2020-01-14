package example;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import net.rootdev.jenajung.JenaJungGraph;
import net.rootdev.jenajung.Transformers;
import net.rootdev.jenajung.examples.ToImage;
import org.apache.commons.collections15.Transformer;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColorGraph {
    public void readRDFAsGraph(String path, String profession) {

     Model model = FileManager.get().loadModel(path);
        Graph<RDFNode, Statement> g = new JenaJungGraph(model);
        Layout<RDFNode, Statement> layout = new FRLayout(g);
        layout.setSize(new Dimension(3000, 1500));
        int width = 3000;
        int height =1500;
        VisualizationImageServer<RDFNode, Statement> viz = new VisualizationImageServer<>(layout, new Dimension(width, height));
        RenderContext context = viz.getRenderContext();
        context.setEdgeLabelTransformer(Transformers.EDGE);
        context.setVertexLabelTransformer(Transformers.NODE);
        viz.setPreferredSize(new Dimension(3000, 1500));

        if (profession != null) {
            Transformer<RDFNode, Paint> vertexColor = node -> {
                Property property = ResourceFactory.createProperty("http://www.example.org/schemas/project", "occupation");
                if (node.isResource() && node.asResource().getProperty(property).getString().equals(profession)) {
                    return Color.GREEN;
                }
                return Color.RED;
            };
            viz.getRenderContext().setVertexFillPaintTransformer(vertexColor);
        }
        viz.setPreferredSize(new Dimension(width, height));
        Image img = viz.getImage(new Point(width/2, height/2), new Dimension(width, height));

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        // Fill the background in white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        // Draw the image
        g2d.setColor(Color.white);
        g2d.drawImage(img, 0, 0, width, height, Color.blue, null);


        try {
            // Save the image to a file
            System.out.println("me");
            ImageIO.write(bi, "PNG", new File("/home/miruna/Documents/Project/web/images/aaa.png"));
            System.out.println("Image saved");
        } catch (IOException ex) {
            Logger.getLogger(ToImage.class.getName()).log(Level.SEVERE, null, ex);
        }

//        JFrame frame = new JFrame("Jena Graph");
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.getContentPane().add(viz);
//        frame.pack();
    }
}
