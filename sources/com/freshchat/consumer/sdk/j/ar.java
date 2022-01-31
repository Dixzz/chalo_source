package com.freshchat.consumer.sdk.j;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.LinkedList;

public class ar<E> extends LinkedList<E> implements Collection, List {
    private int maxSize;

    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, java.util.Deque, java.util.AbstractCollection, java.util.List, java.util.Queue, java.util.LinkedList
    public boolean add(E e) {
        boolean add = super.add(e);
        if (size() > getMaxSize()) {
            removeFirst();
        }
        return add;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // j$.util.List, java.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, java.lang.Iterable, java.util.List, j$.lang.Iterable, java.util.LinkedList
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    public void v(int i) {
        this.maxSize = i;
    }
}
