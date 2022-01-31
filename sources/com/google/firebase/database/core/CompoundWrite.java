package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

public final class CompoundWrite implements Iterable<Map.Entry<Path, Node>>, Iterable {
    private static final CompoundWrite EMPTY = new CompoundWrite(new ImmutableTree(null));
    private final ImmutableTree<Node> writeTree;

    private CompoundWrite(ImmutableTree<Node> immutableTree) {
        this.writeTree = immutableTree;
    }

    private Node applySubtreeWrite(Path path, ImmutableTree<Node> immutableTree, Node node) {
        if (immutableTree.getValue() != null) {
            return node.updateChild(path, immutableTree.getValue());
        }
        Node node2 = null;
        Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = immutableTree.getChildren().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
            ImmutableTree<Node> value = next.getValue();
            ChildKey key = next.getKey();
            if (key.isPriorityChildName()) {
                Utilities.hardAssert(value.getValue() != null, "Priority writes must always be leaf nodes");
                node2 = value.getValue();
            } else {
                node = applySubtreeWrite(path.child(key), value, node);
            }
        }
        return (node.getChild(path).isEmpty() || node2 == null) ? node : node.updateChild(path.child(ChildKey.getPriorityKey()), node2);
    }

    public static CompoundWrite emptyWrite() {
        return EMPTY;
    }

    public static CompoundWrite fromChildMerge(Map<ChildKey, Node> map) {
        ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
        for (Map.Entry<ChildKey, Node> entry : map.entrySet()) {
            emptyInstance = emptyInstance.setTree(new Path(entry.getKey()), new ImmutableTree(entry.getValue()));
        }
        return new CompoundWrite(emptyInstance);
    }

    public static CompoundWrite fromPathMerge(Map<Path, Node> map) {
        ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
        for (Map.Entry<Path, Node> entry : map.entrySet()) {
            emptyInstance = emptyInstance.setTree(entry.getKey(), new ImmutableTree(entry.getValue()));
        }
        return new CompoundWrite(emptyInstance);
    }

    public static CompoundWrite fromValue(Map<String, Object> map) {
        ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            emptyInstance = emptyInstance.setTree(new Path(entry.getKey()), new ImmutableTree(NodeUtilities.NodeFromJSON(entry.getValue())));
        }
        return new CompoundWrite(emptyInstance);
    }

    public CompoundWrite addWrite(Path path, Node node) {
        if (path.isEmpty()) {
            return new CompoundWrite(new ImmutableTree(node));
        }
        Path findRootMostPathWithValue = this.writeTree.findRootMostPathWithValue(path);
        if (findRootMostPathWithValue != null) {
            Path relative = Path.getRelative(findRootMostPathWithValue, path);
            Node node2 = this.writeTree.get(findRootMostPathWithValue);
            ChildKey back = relative.getBack();
            if (back != null && back.isPriorityChildName() && node2.getChild(relative.getParent()).isEmpty()) {
                return this;
            }
            return new CompoundWrite(this.writeTree.set(findRootMostPathWithValue, node2.updateChild(relative, node)));
        }
        return new CompoundWrite(this.writeTree.setTree(path, new ImmutableTree<>(node)));
    }

    public CompoundWrite addWrites(final Path path, CompoundWrite compoundWrite) {
        return (CompoundWrite) compoundWrite.writeTree.fold(this, new ImmutableTree.TreeVisitor<Node, CompoundWrite>() {
            /* class com.google.firebase.database.core.CompoundWrite.AnonymousClass1 */

            public CompoundWrite onNodeValue(Path path, Node node, CompoundWrite compoundWrite) {
                return compoundWrite.addWrite(path.child(path), node);
            }
        });
    }

    public Node apply(Node node) {
        return applySubtreeWrite(Path.getEmptyPath(), this.writeTree, node);
    }

    public CompoundWrite childCompoundWrite(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        Node completeNode = getCompleteNode(path);
        if (completeNode != null) {
            return new CompoundWrite(new ImmutableTree(completeNode));
        }
        return new CompoundWrite(this.writeTree.subtree(path));
    }

    public Map<ChildKey, CompoundWrite> childCompoundWrites() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = this.writeTree.getChildren().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
            hashMap.put(next.getKey(), new CompoundWrite(next.getValue()));
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != CompoundWrite.class) {
            return false;
        }
        return ((CompoundWrite) obj).getValue(true).equals(getValue(true));
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public List<NamedNode> getCompleteChildren() {
        ArrayList arrayList = new ArrayList();
        if (this.writeTree.getValue() != null) {
            for (NamedNode namedNode : this.writeTree.getValue()) {
                arrayList.add(new NamedNode(namedNode.getName(), namedNode.getNode()));
            }
        } else {
            Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = this.writeTree.getChildren().iterator();
            while (it.hasNext()) {
                Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
                ImmutableTree<Node> value = next.getValue();
                if (value.getValue() != null) {
                    arrayList.add(new NamedNode(next.getKey(), value.getValue()));
                }
            }
        }
        return arrayList;
    }

    public Node getCompleteNode(Path path) {
        Path findRootMostPathWithValue = this.writeTree.findRootMostPathWithValue(path);
        if (findRootMostPathWithValue != null) {
            return this.writeTree.get(findRootMostPathWithValue).getChild(Path.getRelative(findRootMostPathWithValue, path));
        }
        return null;
    }

    public Map<String, Object> getValue(final boolean z) {
        final HashMap hashMap = new HashMap();
        this.writeTree.foreach(new ImmutableTree.TreeVisitor<Node, Void>() {
            /* class com.google.firebase.database.core.CompoundWrite.AnonymousClass2 */

            public Void onNodeValue(Path path, Node node, Void r4) {
                hashMap.put(path.wireFormat(), node.getValue(z));
                return null;
            }
        });
        return hashMap;
    }

    public boolean hasCompleteWrite(Path path) {
        return getCompleteNode(path) != null;
    }

    public int hashCode() {
        return getValue(true).hashCode();
    }

    public boolean isEmpty() {
        return this.writeTree.isEmpty();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<Map.Entry<Path, Node>> iterator() {
        return this.writeTree.iterator();
    }

    public CompoundWrite removeWrite(Path path) {
        if (path.isEmpty()) {
            return EMPTY;
        }
        return new CompoundWrite(this.writeTree.setTree(path, ImmutableTree.emptyInstance()));
    }

    public Node rootWrite() {
        return this.writeTree.getValue();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Map.Entry<Path, Node>> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CompoundWrite{");
        i0.append(getValue(true).toString());
        i0.append("}");
        return i0.toString();
    }

    public CompoundWrite addWrite(ChildKey childKey, Node node) {
        return addWrite(new Path(childKey), node);
    }
}
