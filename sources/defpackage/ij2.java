package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: ij2  reason: default package */
public final class ij2 implements Iterator<String>, j$.util.Iterator {
    public Iterator<String> f;
    public final /* synthetic */ gj2 g;

    public ij2(gj2 gj2) {
        this.g = gj2;
        this.f = gj2.f.iterator();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // j$.util.Iterator, java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f.next();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
