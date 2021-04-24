import java.util.ArrayList;
import java.util.List;

public class Node {

    private String label;
    private List<Edge> edges = new ArrayList<>();

    public Node(String label) {
        setLabel(label);
    }

    @Override
    public String toString() {
        return label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label.toUpperCase();
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public void addEdge(Node toNode, int weight){
        edges.add(new Edge(this, toNode, weight));
    }
}
