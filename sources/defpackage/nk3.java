package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: nk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class nk3 implements Iterator<String>, j$.util.Iterator {
    public Iterator<String> f;
    public final /* synthetic */ lk3 g;

    public nk3(lk3 lk3) {
        this.g = lk3;
        this.f = lk3.f.iterator();
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
