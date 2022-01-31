package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: d66  reason: default package */
/* compiled from: Sets.kt */
public final class d66 implements Set, Serializable, c96, j$.util.Set {
    public static final d66 f = new d66();

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            n86.e((Void) obj, "element");
        }
        return false;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(Collection collection) {
        n86.e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, j$.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public Iterator iterator() {
        return a66.f;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.Set
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public Object[] toArray() {
        return i86.a(this);
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i86.b(this, tArr);
    }

    public String toString() {
        return "[]";
    }
}
