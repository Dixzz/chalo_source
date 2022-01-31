package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: b66  reason: default package */
/* compiled from: Collections.kt */
public final class b66 implements List, Serializable, RandomAccess, c96, j$.util.List {
    public static final b66 f = new b66();

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.List
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            n86.e((Void) obj, "element");
        }
        return false;
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean containsAll(Collection collection) {
        n86.e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.List, j$.util.List
    public Object get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    @Override // j$.util.Collection, j$.util.List
    public int hashCode() {
        return 1;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Void) {
            n86.e((Void) obj, "element");
        }
        return -1;
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean isEmpty() {
        return true;
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public Iterator iterator() {
        return a66.f;
    }

    @Override // j$.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            n86.e((Void) obj, "element");
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator() {
        return a66.f;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.List
    public final /* bridge */ int size() {
        return 0;
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
    public java.util.List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(hj1.L("fromIndex: ", i, ", toIndex: ", i2));
    }

    @Override // j$.util.Collection, j$.util.List
    public Object[] toArray() {
        return i86.a(this);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i86.b(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator(int i) {
        if (i == 0) {
            return a66.f;
        }
        throw new IndexOutOfBoundsException(hj1.I("Index: ", i));
    }
}
