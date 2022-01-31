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
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: gj2  reason: default package */
public final class gj2 extends AbstractList<String> implements jh2, RandomAccess, List {
    public final jh2 f;

    public gj2(jh2 jh2) {
        this.f = jh2;
    }

    @Override // defpackage.jh2
    public final Object a(int i) {
        return this.f.a(i);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // defpackage.jh2
    public final java.util.List<?> g() {
        return this.f.g();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ String get(int i) {
        return (String) this.f.get(i);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new ij2(this);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final ListIterator<String> listIterator(int i) {
        return new hj2(this, i);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // defpackage.jh2
    public final jh2 r() {
        return this;
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.f.size();
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
