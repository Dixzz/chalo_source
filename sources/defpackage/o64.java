package defpackage;

import com.google.android.gms.measurement.internal.zzap;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: o64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class o64 implements Iterator<String>, j$.util.Iterator {
    public Iterator<String> f;
    public final /* synthetic */ zzap g;

    public o64(zzap zzap) {
        this.g = zzap;
        this.f = zzap.f.keySet().iterator();
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
        throw new UnsupportedOperationException("Remove not supported");
    }
}
