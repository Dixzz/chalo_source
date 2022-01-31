package com.google.firebase.database.collection;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
    private final boolean isReverse;
    private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();

    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k, Comparator<K> comparator, boolean z) {
        int i;
        this.isReverse = z;
        while (!lLRBNode.isEmpty()) {
            if (k != null) {
                i = z ? comparator.compare(k, lLRBNode.getKey()) : comparator.compare(lLRBNode.getKey(), k);
            } else {
                i = 1;
            }
            if (i < 0) {
                if (z) {
                    lLRBNode = lLRBNode.getLeft();
                } else {
                    lLRBNode = lLRBNode.getRight();
                }
            } else if (i == 0) {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                return;
            } else {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                if (z) {
                    lLRBNode = lLRBNode.getRight();
                } else {
                    lLRBNode = lLRBNode.getLeft();
                }
            }
        }
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return this.nodeStack.size() > 0;
    }

    @Override // j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> pop = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.isReverse) {
                for (LLRBNode<K, V> left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.nodeStack.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode<K, V> right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.nodeStack.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
