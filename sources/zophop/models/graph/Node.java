package zophop.models.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Node extends GraphEntity {
    private HashMap<Label, ArrayList<Edge>> incomingEdges = new HashMap<>();
    private HashMap<Label, ArrayList<Edge>> outgoingEdges = new HashMap<>();

    public Node(Label label) {
        this.label = label;
    }

    private void addIncomingEdge(Edge edge) {
        ArrayList<Edge> arrayList = this.incomingEdges.get(edge.getLabel());
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(edge);
        this.incomingEdges.put(edge.getLabel(), arrayList);
    }

    private void addOutgoingEdge(Edge edge) {
        ArrayList<Edge> arrayList = this.outgoingEdges.get(edge.getLabel());
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(edge);
        this.outgoingEdges.put(edge.getLabel(), arrayList);
    }

    public Edge createEdge(Node node, Label label) {
        Edge edge = new Edge(label);
        edge.setStartNode(this);
        edge.setEndNode(node);
        addOutgoingEdge(edge);
        node.addIncomingEdge(edge);
        return edge;
    }

    public int getDegree() {
        return getOutGoingDegree() + getIncomingDegree();
    }

    public int getIncomingDegree() {
        int i = 0;
        for (ArrayList<Edge> arrayList : this.incomingEdges.values()) {
            i += arrayList.size();
        }
        return i;
    }

    public ArrayList<Edge> getIncomingEdges(Label label) {
        ArrayList<Edge> arrayList = this.incomingEdges.get(label);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getOutGoingDegree() {
        int i = 0;
        for (ArrayList<Edge> arrayList : this.outgoingEdges.values()) {
            i += arrayList.size();
        }
        return i;
    }

    public ArrayList<Edge> getOutGoingEdges(Label label) {
        ArrayList<Edge> arrayList = this.outgoingEdges.get(label);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }
}
