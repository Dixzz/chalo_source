package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: st3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class st3 implements Iterator, j$.util.Iterator {
    public int f = 0;
    public final int g;
    public final /* synthetic */ qt3 h;

    public st3(qt3 qt3) {
        this.h = qt3;
        this.g = qt3.d();
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
