package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

/* renamed from: hj2  reason: default package */
public final class hj2 implements ListIterator<String>, Iterator {
    public ListIterator<String> f;
    public final /* synthetic */ int g;
    public final /* synthetic */ gj2 h;

    public hj2(gj2 gj2, int i) {
        this.h = gj2;
        this.g = i;
        this.f = gj2.f.listIterator(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f.hasPrevious();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // j$.util.Iterator, java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.f.next();
    }

    public final int nextIndex() {
        return this.f.nextIndex();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f.previous();
    }

    public final int previousIndex() {
        return this.f.previousIndex();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
