package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public abstract class ImmutableSortedMap<K, V> implements Iterable<Map.Entry<K, V>>, Iterable {

    /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
    public static class Builder {
        public static final int ARRAY_TO_RB_TREE_SIZE_THRESHOLD = 25;
        private static final KeyTranslator IDENTITY_TRANSLATOR = ImmutableSortedMap$Builder$$Lambda$1.lambdaFactory$();

        /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
        public interface KeyTranslator<C, D> {
            D translate(C c);
        }

        public static <A, B, C> ImmutableSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            if (list.size() < 25) {
                return ArraySortedMap.buildFrom(list, map, keyTranslator, comparator);
            }
            return RBTreeSortedMap.buildFrom(list, map, keyTranslator, comparator);
        }

        public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<K> comparator) {
            return new ArraySortedMap(comparator);
        }

        public static <A, B> ImmutableSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator) {
            if (map.size() < 25) {
                return ArraySortedMap.fromMap(map, comparator);
            }
            return RBTreeSortedMap.fromMap(map, comparator);
        }

        public static <A> KeyTranslator<A, A> identityTranslator() {
            return IDENTITY_TRANSLATOR;
        }

        public static /* synthetic */ Object lambda$static$0(Object obj) {
            return obj;
        }
    }

    public abstract boolean containsKey(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedMap)) {
            return false;
        }
        ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap) obj;
        if (!getComparator().equals(immutableSortedMap.getComparator()) || size() != immutableSortedMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = immutableSortedMap.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public abstract V get(K k);

    public abstract Comparator<K> getComparator();

    public abstract K getMaxKey();

    public abstract K getMinKey();

    public abstract K getPredecessorKey(K k);

    public abstract K getSuccessorKey(K k);

    public int hashCode() {
        int hashCode = getComparator().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            hashCode = (hashCode * 31) + it.next().hashCode();
        }
        return hashCode;
    }

    public abstract void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor);

    public abstract int indexOf(K k);

    public abstract ImmutableSortedMap<K, V> insert(K k, V v);

    public abstract boolean isEmpty();

    @Override // j$.lang.Iterable, java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract Iterator<Map.Entry<K, V>> iteratorFrom(K k);

    public abstract ImmutableSortedMap<K, V> remove(K k);

    public abstract Iterator<Map.Entry<K, V>> reverseIterator();

    public abstract Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k);

    public abstract int size();

    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator<Map.Entry<K, V>> it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append((Object) next.getKey());
            sb.append("=>");
            sb.append((Object) next.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }
}
