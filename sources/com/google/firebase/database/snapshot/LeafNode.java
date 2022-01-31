package com.google.firebase.database.snapshot;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;

public abstract class LeafNode<T extends LeafNode> implements Node {
    private String lazyHash;
    public final Node priority;

    /* renamed from: com.google.firebase.database.snapshot.LeafNode$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.google.firebase.database.snapshot.Node.HashVersion.values()
                r0 = 2
                int[] r1 = new int[r0]
                com.google.firebase.database.snapshot.LeafNode.AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion = r1
                r2 = 1
                com.google.firebase.database.snapshot.Node$HashVersion r3 = com.google.firebase.database.snapshot.Node.HashVersion.V1     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r1 = com.google.firebase.database.snapshot.LeafNode.AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.database.snapshot.Node$HashVersion r3 = com.google.firebase.database.snapshot.Node.HashVersion.V2     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.snapshot.LeafNode.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LeafType {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    public LeafNode(Node node) {
        this.priority = node;
    }

    private static int compareLongDoubleNodes(LongNode longNode, DoubleNode doubleNode) {
        return Double.valueOf((double) ((Long) longNode.getValue()).longValue()).compareTo((Double) doubleNode.getValue());
    }

    public abstract int compareLeafValues(T t);

    public abstract boolean equals(Object obj);

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getChild(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        if (path.getFront().isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        if (this.lazyHash == null) {
            this.lazyHash = Utilities.sha1HexDigest(getHashRepresentation(Node.HashVersion.V1));
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getImmediateChild(ChildKey childKey) {
        if (childKey.isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    public abstract LeafType getLeafType();

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.priority;
    }

    public String getPriorityHash(Node.HashVersion hashVersion) {
        int ordinal = hashVersion.ordinal();
        if (ordinal != 0 && ordinal != 1) {
            throw new IllegalArgumentException("Unknown hash version: " + hashVersion);
        } else if (this.priority.isEmpty()) {
            return "";
        } else {
            StringBuilder i0 = hj1.i0("priority:");
            i0.append(this.priority.getHashRepresentation(hashVersion));
            i0.append(ProductDiscountsObject.KEY_DELIMITER);
            return i0.toString();
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z) {
        if (!z || this.priority.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.priority.getValue());
        return hashMap;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(ChildKey childKey) {
        return false;
    }

    public abstract int hashCode();

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return true;
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    public int leafCompare(LeafNode<?> leafNode) {
        LeafType leafType = getLeafType();
        LeafType leafType2 = leafNode.getLeafType();
        if (leafType.equals(leafType2)) {
            return compareLeafValues(leafNode);
        }
        return leafType.compareTo((Enum) leafType2);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<NamedNode> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        String obj = getValue(true).toString();
        if (obj.length() <= 100) {
            return obj;
        }
        return obj.substring(0, 100) + "...";
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateChild(Path path, Node node) {
        ChildKey front = path.getFront();
        if (front == null) {
            return node;
        }
        if (node.isEmpty() && !front.isPriorityChildName()) {
            return this;
        }
        boolean z = true;
        if (path.getFront().isPriorityChildName() && path.size() != 1) {
            z = false;
        }
        Utilities.hardAssert(z);
        return updateImmediateChild(front, EmptyNode.Empty().updateChild(path.popFront(), node));
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateImmediateChild(ChildKey childKey, Node node) {
        if (childKey.isPriorityChildName()) {
            return updatePriority(node);
        }
        if (node.isEmpty()) {
            return this;
        }
        return EmptyNode.Empty().updateImmediateChild(childKey, node).updatePriority(this.priority);
    }

    public int compareTo(Node node) {
        if (node.isEmpty()) {
            return 1;
        }
        if (node instanceof ChildrenNode) {
            return -1;
        }
        Utilities.hardAssert(node.isLeafNode(), "Node is not leaf node!");
        if ((this instanceof LongNode) && (node instanceof DoubleNode)) {
            return compareLongDoubleNodes((LongNode) this, (DoubleNode) node);
        }
        if (!(this instanceof DoubleNode) || !(node instanceof LongNode)) {
            return leafCompare((LeafNode) node);
        }
        return compareLongDoubleNodes((LongNode) node, (DoubleNode) this) * -1;
    }
}
