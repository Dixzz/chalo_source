package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public class ImmutableSortedSet<T> implements Iterable<T>, Iterable {
    private final ImmutableSortedMap<T, Void> map;

    /* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
    public static class WrappedEntryIterator<T> implements Iterator<T>, j$.util.Iterator {
        public final Iterator<Map.Entry<T, Void>> iterator;

        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> it) {
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

        @Override // j$.util.Iterator, java.util.Iterator
        public T next() {
            return this.iterator.next().getKey();
        }

        @Override // j$.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.map = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    public boolean contains(T t) {
        return this.map.containsKey(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedSet)) {
            return false;
        }
        return this.map.equals(((ImmutableSortedSet) obj).map);
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public T getMaxEntry() {
        return this.map.getMaxKey();
    }

    public T getMinEntry() {
        return this.map.getMinKey();
    }

    public T getPredecessorEntry(T t) {
        return this.map.getPredecessorKey(t);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public int indexOf(T t) {
        return this.map.indexOf(t);
    }

    public ImmutableSortedSet<T> insert(T t) {
        return new ImmutableSortedSet<>(this.map.insert(t, null));
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new WrappedEntryIterator(this.map.iterator());
    }

    public java.util.Iterator<T> iteratorFrom(T t) {
        return new WrappedEntryIterator(this.map.iteratorFrom(t));
    }

    public ImmutableSortedSet<T> remove(T t) {
        ImmutableSortedMap<T, Void> remove = this.map.remove(t);
        return remove == this.map ? this : new ImmutableSortedSet<>(remove);
    }

    public java.util.Iterator<T> reverseIterator() {
        return new WrappedEntryIterator(this.map.reverseIterator());
    }

    public java.util.Iterator<T> reverseIteratorFrom(T t) {
        return new WrappedEntryIterator(this.map.reverseIteratorFrom(t));
    }

    public int size() {
        return this.map.size();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public ImmutableSortedSet<T> unionWith(ImmutableSortedSet<T> immutableSortedSet) {
        ImmutableSortedSet<T> immutableSortedSet2;
        if (size() < immutableSortedSet.size()) {
            immutableSortedSet2 = immutableSortedSet;
            immutableSortedSet = this;
        } else {
            immutableSortedSet2 = this;
        }
        java.util.Iterator<T> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            immutableSortedSet2 = immutableSortedSet2.insert(it.next());
        }
        return immutableSortedSet2;
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.map = immutableSortedMap;
    }
}
