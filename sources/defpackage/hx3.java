package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: hx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class hx3 implements Iterator<String>, j$.util.Iterator {
    public Iterator<String> f;
    public final /* synthetic */ fx3 g;

    public hx3(fx3 fx3) {
        this.g = fx3;
        this.f = fx3.f.iterator();
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
