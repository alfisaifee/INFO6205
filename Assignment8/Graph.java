import java.util.*;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    public void addEdges(String from, String to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public String shortestPath(Node fromNode, Node toNode){
        Map<Node, Integer> distances = new HashMap<>();
        for(Node node : nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);
        Map<Node, Node> previousNode = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(NodeEntry::getPriority)
        );
        queue.add(new NodeEntry(fromNode, 0));
        while(!queue.isEmpty()){
            Node curr = queue.remove().getNode();
            visited.add(curr);
            for(Edge edge : curr.getEdges()){
                Node edgeNode = edge.getTo();
                if(visited.contains(edgeNode))
                    continue;
                int newDistance = distances.get(curr) + edge.getWeight();
                if(newDistance < distances.get(edgeNode)){
                    distances.replace(edgeNode, newDistance);
                    previousNode.put(edgeNode, curr);
                    queue.add(new NodeEntry(edgeNode, newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.add(toNode);
        Node previous = previousNode.get(toNode);
        while(previous != null){
            stack.add(previous);
            previous = previousNode.get(previous);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop().getLabel());
            if(stack.size() >= 1)
                res.append(" --> ");
        }

        return res.toString();
    }

    public void printAllShortestPaths(String from){
        Node fromNode = nodes.get(from);
        for(Node node : nodes.values()){
            if(node != nodes.get(from)) {
                System.out.printf("Shortest Path from %s to %s : ",from, node.getLabel());
                System.out.println(shortestPath(fromNode, node));
            }
        }
    }
}
