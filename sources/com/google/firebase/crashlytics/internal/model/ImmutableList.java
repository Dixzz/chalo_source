package com.google.firebase.crashlytics.internal.model;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess, j$.util.List {
    private final List<E> immutableList;

    private ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean add(E e) {
        return this.immutableList.add(e);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean addAll(Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    @Override // j$.util.Collection, j$.util.List
    public void clear() {
        this.immutableList.clear();
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean contains(Object obj) {
        return this.immutableList.contains(obj);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean containsAll(Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        return this.immutableList.equals(obj);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.List, j$.util.List
    public E get(int i) {
        return this.immutableList.get(i);
    }

    @Override // j$.util.Collection, j$.util.List
    public int hashCode() {
        return this.immutableList.hashCode();
    }

    @Override // j$.util.List
    public int indexOf(Object obj) {
        return this.immutableList.indexOf(obj);
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    @Override // j$.util.List
    public int lastIndexOf(Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List
    public boolean remove(Object obj) {
        return this.immutableList.remove(obj);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean removeAll(java.util.Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean retainAll(java.util.Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    @Override // java.util.List, j$.util.List
    public E set(int i, E e) {
        return this.immutableList.set(i, e);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.immutableList.size();
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    @Override // java.util.List, j$.util.List
    public java.util.List<E> subList(int i, int i2) {
        return this.immutableList.subList(i, i2);
    }

    @Override // j$.util.Collection, j$.util.List
    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public static <E> ImmutableList<E> from(java.util.List<E> list) {
        return new ImmutableList<>(list);
    }

    @Override // java.util.List, j$.util.List
    public void add(int i, E e) {
        this.immutableList.add(i, e);
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        return this.immutableList.addAll(i, collection);
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator(int i) {
        return this.immutableList.listIterator(i);
    }

    @Override // java.util.List, j$.util.List
    public E remove(int i) {
        return this.immutableList.remove(i);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.immutableList.toArray(tArr);
    }
}
