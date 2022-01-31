package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import j$.lang.Iterable;
import java.util.Iterator;

public interface Node extends Comparable<Node>, Iterable<NamedNode>, Iterable {
    public static final ChildrenNode MAX_NODE = new ChildrenNode() {
        /* class com.google.firebase.database.snapshot.Node.AnonymousClass1 */

        @Override // com.google.firebase.database.snapshot.ChildrenNode
        public int compareTo(Node node) {
            return node == this ? 0 : 1;
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
        public Node getImmediateChild(ChildKey childKey) {
            if (childKey.isPriorityChildName()) {
                return getPriority();
            }
            return EmptyNode.Empty();
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
        public Node getPriority() {
            return this;
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
        public boolean hasChild(ChildKey childKey) {
            return false;
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
        public boolean isEmpty() {
            return false;
        }

        @Override // com.google.firebase.database.snapshot.ChildrenNode
        public String toString() {
            return "<Max Node>";
        }
    };

    public enum HashVersion {
        V1,
        V2
    }

    Node getChild(Path path);

    int getChildCount();

    String getHash();

    String getHashRepresentation(HashVersion hashVersion);

    Node getImmediateChild(ChildKey childKey);

    ChildKey getPredecessorChildKey(ChildKey childKey);

    Node getPriority();

    ChildKey getSuccessorChildKey(ChildKey childKey);

    Object getValue();

    Object getValue(boolean z);

    boolean hasChild(ChildKey childKey);

    boolean isEmpty();

    boolean isLeafNode();

    Iterator<NamedNode> reverseIterator();

    Node updateChild(Path path, Node node);

    Node updateImmediateChild(ChildKey childKey, Node node);

    Node updatePriority(Node node);
}
