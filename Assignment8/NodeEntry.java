public class NodeEntry {
    private Node node;
    private int priority;

    public NodeEntry(Node node, int priority) {
        setNode(node);
        setPriority(priority);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
