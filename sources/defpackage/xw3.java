package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: xw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class xw3 implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
    public int f = -1;
    public boolean g;
    public Iterator<Map.Entry<K, V>> h;
    public final /* synthetic */ rw3 i;

    public xw3(rw3 rw3, tw3 tw3) {
        this.i = rw3;
    }

    public final Iterator<Map.Entry<K, V>> a() {
        if (this.h == null) {
            this.h = this.i.h.entrySet().iterator();
        }
        return this.h;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        if (this.f + 1 < this.i.g.size() || (!this.i.h.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        this.g = true;
        int i2 = this.f + 1;
        this.f = i2;
        if (i2 < this.i.g.size()) {
            return this.i.g.get(this.f);
        }
        return (Map.Entry) a().next();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        if (this.g) {
            this.g = false;
            rw3 rw3 = this.i;
            int i2 = rw3.l;
            rw3.h();
            if (this.f < this.i.g.size()) {
                rw3 rw32 = this.i;
                int i3 = this.f;
                this.f = i3 - 1;
                rw32.f(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
