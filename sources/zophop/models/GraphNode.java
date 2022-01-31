package zophop.models;

public class GraphNode {
    public String label;
    public String stopId;

    public boolean equals(Object obj) {
        if (!(obj instanceof GraphNode)) {
            return false;
        }
        GraphNode graphNode = (GraphNode) obj;
        if (graphNode.label.equals(this.label) && graphNode.stopId.equals(this.stopId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.stopId.hashCode() + this.label.hashCode();
    }
}
