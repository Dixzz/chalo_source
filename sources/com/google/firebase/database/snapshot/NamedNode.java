package com.google.firebase.database.snapshot;

public final class NamedNode {
    private static final NamedNode MAX_NODE = new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
    private static final NamedNode MIN_NODE = new NamedNode(ChildKey.getMinName(), EmptyNode.Empty());
    private final ChildKey name;
    private final Node node;

    public NamedNode(ChildKey childKey, Node node2) {
        this.name = childKey;
        this.node = node2;
    }

    public static NamedNode getMaxNode() {
        return MAX_NODE;
    }

    public static NamedNode getMinNode() {
        return MIN_NODE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NamedNode.class != obj.getClass()) {
            return false;
        }
        NamedNode namedNode = (NamedNode) obj;
        return this.name.equals(namedNode.name) && this.node.equals(namedNode.node);
    }

    public ChildKey getName() {
        return this.name;
    }

    public Node getNode() {
        return this.node;
    }

    public int hashCode() {
        return this.node.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("NamedNode{name=");
        i0.append(this.name);
        i0.append(", node=");
        i0.append(this.node);
        i0.append('}');
        return i0.toString();
    }
}
