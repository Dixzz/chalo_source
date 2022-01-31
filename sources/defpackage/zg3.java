package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: zg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zg3 implements Iterator, j$.util.Iterator {
    public int f = 0;
    public final int g;
    public final /* synthetic */ xg3 h;

    public zg3(xg3 xg3) {
        this.h = xg3;
        this.g = xg3.size();
    }

    public final byte a() {
        int i = this.f;
        if (i < this.g) {
            this.f = i + 1;
            return this.h.v(i);
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f < this.g;
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
