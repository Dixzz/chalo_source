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

/* renamed from: en2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class en2 extends AbstractList<String> implements RandomAccess, nl2, List {
    public final nl2 f;

    public en2(nl2 nl2) {
        this.f = nl2;
    }

    @Override // defpackage.nl2
    public final void X(g93 g93) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.nl2
    public final Object Z0(int i) {
        return this.f.Z0(i);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* bridge */ /* synthetic */ String get(int i) {
        return ((ml2) this.f).get(i);
    }

    @Override // defpackage.nl2
    public final nl2 h() {
        return this;
    }

    @Override // defpackage.nl2
    public final java.util.List<?> i() {
        return this.f.i();
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new dn2(this);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final ListIterator<String> listIterator(int i) {
        return new cn2(this, i);
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
}
