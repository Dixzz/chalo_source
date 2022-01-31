package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: w56  reason: default package */
/* compiled from: Collections.kt */
public final class w56<T> implements Collection<T>, c96, j$.util.Collection {
    public final T[] f;
    public final boolean g;

    public w56(T[] tArr, boolean z) {
        n86.e(tArr, "values");
        this.f = tArr;
        this.g = z;
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public boolean contains(Object obj) {
        return hd3.N(this.f, obj);
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        n86.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection
    public boolean isEmpty() {
        return this.f.length == 0;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        T[] tArr = this.f;
        n86.e(tArr, "array");
        return new e86(tArr);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean removeAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public final int size() {
        return this.f.length;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Collection.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    @Override // j$.util.Collection
    public final Object[] toArray() {
        T[] tArr = this.f;
        boolean z = this.g;
        n86.e(tArr, "$this$copyToArrayOfAny");
        if (z && n86.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        n86.d(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    @Override // j$.util.Collection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i86.b(this, tArr);
    }
}
