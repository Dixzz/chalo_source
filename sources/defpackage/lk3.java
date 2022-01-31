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

/* renamed from: lk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class lk3 extends AbstractList<String> implements mi3, RandomAccess, List {
    public final mi3 f;

    public lk3(mi3 mi3) {
        this.f = mi3;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ String get(int i) {
        return (String) this.f.get(i);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new nk3(this);
    }

    @Override // defpackage.mi3
    public final java.util.List<?> j0() {
        return this.f.j0();
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final ListIterator<String> listIterator(int i) {
        return new kk3(this, i);
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

    @Override // defpackage.mi3
    public final Object w(int i) {
        return this.f.w(i);
    }

    @Override // defpackage.mi3
    public final mi3 x() {
        return this;
    }
}
