package zophop.models.graph;

public class Edge extends GraphEntity {
    private Node endNode;
    private Node startNode;

    public Edge(Label label) {
        this.label = label;
    }

    public Node getEndNode() {
        return this.endNode;
    }

    public Node getStartNode() {
        return this.startNode;
    }

    public void setEndNode(Node node) {
        this.endNode = node;
    }

    public void setStartNode(Node node) {
        this.startNode = node;
    }
}
