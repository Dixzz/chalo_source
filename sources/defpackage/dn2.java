package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: dn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dn2 implements Iterator<String>, j$.util.Iterator {
    public final Iterator<String> f;
    public final /* synthetic */ en2 g;

    public dn2(en2 en2) {
        this.g = en2;
        this.f = en2.f.iterator();
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
    public final /* bridge */ /* synthetic */ String next() {
        return this.f.next();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
