public class Edge {

    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
        setFrom(from);
        setTo(to);
        setWeight(weight);
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight < 0)
            throw new IllegalArgumentException();
        this.weight = weight;
    }
}
