package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.RandomAccess;

/* renamed from: of2  reason: default package */
public abstract class of2<E> extends AbstractList<E> implements zg2<E>, List {
    public boolean f = true;

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List
    public boolean add(E e) {
        b();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        b();
        return super.addAll(i, collection);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List
    public boolean addAll(Collection<? extends E> collection) {
        b();
        return super.addAll(collection);
    }

    public final void b() {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // j$.util.Collection, j$.util.List
    public void clear() {
        b();
        super.clear();
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        java.util.List list = (java.util.List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, j$.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // defpackage.zg2
    public boolean o() {
        return this.f;
    }

    @Override // defpackage.zg2
    public final void p() {
        this.f = false;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List
    public boolean remove(Object obj) {
        b();
        return super.remove(obj);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List
    public boolean removeAll(java.util.Collection<?> collection) {
        b();
        return super.removeAll(collection);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List
    public boolean retainAll(java.util.Collection<?> collection) {
        b();
        return super.retainAll(collection);
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
}
