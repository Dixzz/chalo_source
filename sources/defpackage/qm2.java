package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: qm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class qm2 implements Iterator<Object>, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
