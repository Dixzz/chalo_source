package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private Comparator<K> comparator;
    private LLRBNode<K, V> root;

    /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
    public static class Builder<A, B, C> {
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private LLRBValueNode<A, C> leaf;
        private LLRBValueNode<A, C> root;
        private final Map<B, C> values;

        /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
        public static class Base1_2 implements Iterable<BooleanChunk>, Iterable {
            private final int length;
            private long value;

            public Base1_2(int i) {
                int i2 = i + 1;
                int floor = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
                this.length = floor;
                this.value = (((long) Math.pow(2.0d, (double) floor)) - 1) & ((long) i2);
            }

            @Override // j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // j$.lang.Iterable, java.lang.Iterable
            public Iterator<BooleanChunk> iterator() {
                return new Object() {
                    /* class com.google.firebase.database.collection.RBTreeSortedMap.Builder.Base1_2.AnonymousClass1 */
                    private int current;

                    {
                        this.current = Base1_2.this.length - 1;
                    }

                    @Override // j$.util.Iterator
                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    @Override // j$.util.Iterator
                    public boolean hasNext() {
                        return this.current >= 0;
                    }

                    @Override // j$.util.Iterator
                    public void remove() {
                    }

                    @Override // j$.util.Iterator, java.util.Iterator
                    public BooleanChunk next() {
                        BooleanChunk booleanChunk = new BooleanChunk();
                        booleanChunk.isOne = (Base1_2.this.value & ((long) (1 << this.current))) == 0;
                        booleanChunk.chunkSize = (int) Math.pow(2.0d, (double) this.current);
                        this.current--;
                        return booleanChunk;
                    }
                };
            }

            /* Return type fixed from 'j$.util.Spliterator' to match base method */
            @Override // j$.lang.Iterable, java.lang.Iterable
            public /* synthetic */ Spliterator<BooleanChunk> spliterator() {
                return Iterable.CC.$default$spliterator(this);
            }
        }

        /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
        public static class BooleanChunk {
            public int chunkSize;
            public boolean isOne;
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2) {
            this.keys = list;
            this.values = map;
            this.keyTranslator = keyTranslator2;
        }

        private LLRBNode<A, C> buildBalancedTree(int i, int i2) {
            if (i2 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i2 == 1) {
                A a2 = this.keys.get(i);
                return new LLRBBlackValueNode(a2, getValue(a2), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            LLRBNode<A, C> buildBalancedTree = buildBalancedTree(i, i3);
            LLRBNode<A, C> buildBalancedTree2 = buildBalancedTree(i4 + 1, i3);
            A a3 = this.keys.get(i4);
            return new LLRBBlackValueNode(a3, getValue(a3), buildBalancedTree, buildBalancedTree2);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator2);
            Collections.sort(list, comparator);
            java.util.Iterator<BooleanChunk> it = new Base1_2(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                BooleanChunk next = it.next();
                int i = next.chunkSize;
                size -= i;
                if (next.isOne) {
                    builder.buildPennant(LLRBNode.Color.BLACK, i, size);
                } else {
                    builder.buildPennant(LLRBNode.Color.BLACK, i, size);
                    int i2 = next.chunkSize;
                    size -= i2;
                    builder.buildPennant(LLRBNode.Color.RED, i2, size);
                }
            }
            LLRBNode lLRBNode = builder.root;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }

        private void buildPennant(LLRBNode.Color color, int i, int i2) {
            LLRBValueNode<A, C> lLRBValueNode;
            LLRBNode<A, C> buildBalancedTree = buildBalancedTree(i2 + 1, i - 1);
            A a2 = this.keys.get(i2);
            if (color == LLRBNode.Color.RED) {
                lLRBValueNode = new LLRBRedValueNode<>(a2, getValue(a2), null, buildBalancedTree);
            } else {
                lLRBValueNode = new LLRBBlackValueNode<>(a2, getValue(a2), null, buildBalancedTree);
            }
            if (this.root == null) {
                this.root = lLRBValueNode;
                this.leaf = lLRBValueNode;
                return;
            }
            this.leaf.setLeft(lLRBValueNode);
            this.leaf = lLRBValueNode;
        }

        private C getValue(A a2) {
            return this.values.get(this.keyTranslator.translate(a2));
        }
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator2) {
        return Builder.buildFrom(list, map, keyTranslator, comparator2);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator2) {
        return Builder.buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private LLRBNode<K, V> getNode(K k) {
        LLRBNode<K, V> lLRBNode = this.root;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else if (compare == 0) {
                return lLRBNode;
            } else {
                lLRBNode = lLRBNode.getRight();
            }
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k) {
        return getNode(k) != null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k) {
        LLRBNode<K, V> node = getNode(k);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k, lLRBNode.getKey());
            if (compare == 0) {
                if (!lLRBNode.getLeft().isEmpty()) {
                    LLRBNode<K, V> left = lLRBNode.getLeft();
                    while (!left.getRight().isEmpty()) {
                        left = left.getRight();
                    }
                    return left.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + ((Object) k));
    }

    public LLRBNode<K, V> getRoot() {
        return this.root;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(lLRBNode.getKey(), k);
            if (compare == 0) {
                if (!lLRBNode.getRight().isEmpty()) {
                    LLRBNode<K, V> right = lLRBNode.getRight();
                    while (!right.getLeft().isEmpty()) {
                        right = right.getLeft();
                    }
                    return right.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getRight();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + ((Object) k));
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k) {
        LLRBNode<K, V> lLRBNode = this.root;
        int i = 0;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k, lLRBNode.getKey());
            if (compare == 0) {
                return lLRBNode.getLeft().size() + i;
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode = lLRBNode.getRight();
                i = lLRBNode.getLeft().size() + 1 + i;
            }
        }
        return -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k, V v) {
        return new RBTreeSortedMap(this.root.insert(k, v, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public java.util.Iterator<Map.Entry<K, V>> iteratorFrom(K k) {
        return new ImmutableSortedMapIterator(this.root, k, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k) {
        if (!containsKey(k)) {
            return this;
        }
        return new RBTreeSortedMap(this.root.remove(k, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public java.util.Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public java.util.Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k) {
        return new ImmutableSortedMapIterator(this.root, k, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.root.size();
    }

    public RBTreeSortedMap(Comparator<K> comparator2) {
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator2;
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator2) {
        this.root = lLRBNode;
        this.comparator = comparator2;
    }
}
