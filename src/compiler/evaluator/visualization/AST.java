package compiler.evaluator.visualization;

import compiler.evaluator.source_tree.statements.Statement;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

public class AST {
    private AST() {
        //DOT is a graphical visualizing format
        exporter = new DOTExporter<>();
        exporter.setVertexAttributeProvider((v) -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(v.toString())); //Name the node
            return map;
        });
        exporter.setEdgeAttributeProvider((e) -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(e.toString())); //Name the edge
            return map;
        });
    }

    private static final AST ast = new AST();
    public org.jgrapht.Graph<Statement, DefaultEdge> g = new Multigraph<>(DefaultEdge.class);

    public static AST instance() {
        return ast;
    }

    private final DOTExporter<Statement, DefaultEdge> exporter;

    public void outputGraph() {
        try {
            Writer writer = new FileWriter("./AST", false);
            exporter.exportGraph(g, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
