package com.google.firebase.database.snapshot;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node;
import j$.lang.Iterable;
import j$.util.Comparator;
import j$.util.Iterator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;

public class ChildrenNode implements Node {
    public static Comparator<ChildKey> NAME_ONLY_COMPARATOR = new Object() {
        /* class com.google.firebase.database.snapshot.ChildrenNode.AnonymousClass1 */

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<ChildKey> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<ChildKey> thenComparing(java.util.Comparator<? super ChildKey> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        public int compare(ChildKey childKey, ChildKey childKey2) {
            return childKey.compareTo(childKey2);
        }
    };
    private final ImmutableSortedMap<ChildKey, Node> children;
    private String lazyHash;
    private final Node priority;

    public static abstract class ChildVisitor extends LLRBNode.NodeVisitor<ChildKey, Node> {
        public abstract void visitChild(ChildKey childKey, Node node);

        public void visitEntry(ChildKey childKey, Node node) {
            visitChild(childKey, node);
        }
    }

    public static class NamedNodeIterator implements Iterator<NamedNode>, j$.util.Iterator {
        private final Iterator<Map.Entry<ChildKey, Node>> iterator;

        public NamedNodeIterator(Iterator<Map.Entry<ChildKey, Node>> it) {
            this.iterator = it;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // j$.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public NamedNode next() {
            Map.Entry<ChildKey, Node> next = this.iterator.next();
            return new NamedNode(next.getKey(), next.getValue());
        }
    }

    public ChildrenNode() {
        this.lazyHash = null;
        this.children = ImmutableSortedMap.Builder.emptyMap(NAME_ONLY_COMPARATOR);
        this.priority = PriorityUtilities.NullPriority();
    }

    private static void addIndentation(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChildrenNode)) {
            return false;
        }
        ChildrenNode childrenNode = (ChildrenNode) obj;
        if (!getPriority().equals(childrenNode.getPriority()) || this.children.size() != childrenNode.children.size()) {
            return false;
        }
        java.util.Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
        java.util.Iterator<Map.Entry<ChildKey, Node>> it2 = childrenNode.children.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            Map.Entry<ChildKey, Node> next2 = it2.next();
            if (!next.getKey().equals(next2.getKey()) || !next.getValue().equals(next2.getValue())) {
                return false;
            }
            while (it.hasNext()) {
                Map.Entry<ChildKey, Node> next3 = it.next();
                Map.Entry<ChildKey, Node> next22 = it2.next();
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public void forEachChild(ChildVisitor childVisitor) {
        forEachChild(childVisitor, false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getChild(Path path) {
        ChildKey front = path.getFront();
        if (front == null) {
            return this;
        }
        return getImmediateChild(front).getChild(path.popFront());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return this.children.size();
    }

    public ChildKey getFirstChildKey() {
        return this.children.getMinKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        if (this.lazyHash == null) {
            String hashRepresentation = getHashRepresentation(Node.HashVersion.V1);
            this.lazyHash = hashRepresentation.isEmpty() ? "" : Utilities.sha1HexDigest(hashRepresentation);
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        boolean z;
        Node.HashVersion hashVersion2 = Node.HashVersion.V1;
        if (hashVersion == hashVersion2) {
            StringBuilder sb = new StringBuilder();
            if (!this.priority.isEmpty()) {
                sb.append("priority:");
                sb.append(this.priority.getHashRepresentation(hashVersion2));
                sb.append(ProductDiscountsObject.KEY_DELIMITER);
            }
            ArrayList arrayList = new ArrayList();
            java.util.Iterator<NamedNode> it = iterator();
            loop0:
            while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    NamedNode next = it.next();
                    arrayList.add(next);
                    if (z || !next.getNode().getPriority().isEmpty()) {
                        z = true;
                    }
                }
            }
            if (z) {
                Collections.sort(arrayList, PriorityIndex.getInstance());
            }
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                NamedNode namedNode = (NamedNode) it2.next();
                String hash = namedNode.getNode().getHash();
                if (!hash.equals("")) {
                    sb.append(ProductDiscountsObject.KEY_DELIMITER);
                    sb.append(namedNode.getName().asString());
                    sb.append(ProductDiscountsObject.KEY_DELIMITER);
                    sb.append(hash);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getImmediateChild(ChildKey childKey) {
        if (childKey.isPriorityChildName() && !this.priority.isEmpty()) {
            return this.priority;
        }
        if (this.children.containsKey(childKey)) {
            return this.children.get(childKey);
        }
        return EmptyNode.Empty();
    }

    public ChildKey getLastChildKey() {
        return this.children.getMaxKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return this.children.getPredecessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.priority;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return this.children.getSuccessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return getValue(false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(ChildKey childKey) {
        return !getImmediateChild(childKey).isEmpty();
    }

    public int hashCode() {
        java.util.Iterator<NamedNode> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            NamedNode next = it.next();
            int hashCode = next.getName().hashCode();
            i = next.getNode().hashCode() + ((hashCode + (i * 31)) * 17);
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return this.children.isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return false;
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<NamedNode> iterator() {
        return new NamedNodeIterator(this.children.iterator());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public java.util.Iterator<NamedNode> reverseIterator() {
        return new NamedNodeIterator(this.children.reverseIterator());
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<NamedNode> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, 0);
        return sb.toString();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateChild(Path path, Node node) {
        ChildKey front = path.getFront();
        if (front == null) {
            return node;
        }
        if (!front.isPriorityChildName()) {
            return updateImmediateChild(front, getImmediateChild(front).updateChild(path.popFront(), node));
        }
        Utilities.hardAssert(PriorityUtilities.isValidPriority(node));
        return updatePriority(node);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateImmediateChild(ChildKey childKey, Node node) {
        if (childKey.isPriorityChildName()) {
            return updatePriority(node);
        }
        ImmutableSortedMap<ChildKey, Node> immutableSortedMap = this.children;
        if (immutableSortedMap.containsKey(childKey)) {
            immutableSortedMap = immutableSortedMap.remove(childKey);
        }
        if (!node.isEmpty()) {
            immutableSortedMap = immutableSortedMap.insert(childKey, node);
        }
        if (immutableSortedMap.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(immutableSortedMap, this.priority);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updatePriority(Node node) {
        if (this.children.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(this.children, node);
    }

    public int compareTo(Node node) {
        if (isEmpty()) {
            return node.isEmpty() ? 0 : -1;
        }
        if (!node.isLeafNode() && !node.isEmpty()) {
            return node == Node.MAX_NODE ? -1 : 0;
        }
        return 1;
    }

    public void forEachChild(final ChildVisitor childVisitor, boolean z) {
        if (!z || getPriority().isEmpty()) {
            this.children.inOrderTraversal(childVisitor);
        } else {
            this.children.inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, Node>() {
                /* class com.google.firebase.database.snapshot.ChildrenNode.AnonymousClass2 */
                public boolean passedPriorityKey = false;

                public void visitEntry(ChildKey childKey, Node node) {
                    if (!this.passedPriorityKey && childKey.compareTo(ChildKey.getPriorityKey()) > 0) {
                        this.passedPriorityKey = true;
                        childVisitor.visitChild(ChildKey.getPriorityKey(), ChildrenNode.this.getPriority());
                    }
                    childVisitor.visitChild(childKey, node);
                }
            });
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z) {
        Integer tryParseInt;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        java.util.Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
        int i = 0;
        boolean z2 = true;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            String asString = next.getKey().asString();
            hashMap.put(asString, next.getValue().getValue(z));
            i++;
            if (z2) {
                if ((asString.length() > 1 && asString.charAt(0) == '0') || (tryParseInt = Utilities.tryParseInt(asString)) == null || tryParseInt.intValue() < 0) {
                    z2 = false;
                } else if (tryParseInt.intValue() > i2) {
                    i2 = tryParseInt.intValue();
                }
            }
        }
        if (z || !z2 || i2 >= i * 2) {
            if (z && !this.priority.isEmpty()) {
                hashMap.put(".priority", this.priority.getValue());
            }
            return hashMap;
        }
        ArrayList arrayList = new ArrayList(i2 + 1);
        for (int i3 = 0; i3 <= i2; i3++) {
            arrayList.add(hashMap.get("" + i3));
        }
        return arrayList;
    }

    private void toString(StringBuilder sb, int i) {
        if (!this.children.isEmpty() || !this.priority.isEmpty()) {
            sb.append("{\n");
            java.util.Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
            while (it.hasNext()) {
                Map.Entry<ChildKey, Node> next = it.next();
                int i2 = i + 2;
                addIndentation(sb, i2);
                sb.append(next.getKey().asString());
                sb.append("=");
                if (next.getValue() instanceof ChildrenNode) {
                    ((ChildrenNode) next.getValue()).toString(sb, i2);
                } else {
                    sb.append(next.getValue().toString());
                }
                sb.append("\n");
            }
            if (!this.priority.isEmpty()) {
                addIndentation(sb, i + 2);
                sb.append(".priority=");
                sb.append(this.priority.toString());
                sb.append("\n");
            }
            addIndentation(sb, i);
            sb.append("}");
            return;
        }
        sb.append("{ }");
    }

    public ChildrenNode(ImmutableSortedMap<ChildKey, Node> immutableSortedMap, Node node) {
        this.lazyHash = null;
        if (!immutableSortedMap.isEmpty() || node.isEmpty()) {
            this.priority = node;
            this.children = immutableSortedMap;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }
}
