package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: dk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class dk3 implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
    public int f = -1;
    public boolean g;
    public Iterator<Map.Entry<K, V>> h;
    public final /* synthetic */ xj3 i;

    public dk3(xj3 xj3, wj3 wj3) {
        this.i = xj3;
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
            xj3 xj3 = this.i;
            int i2 = xj3.l;
            xj3.h();
            if (this.f < this.i.g.size()) {
                xj3 xj32 = this.i;
                int i3 = this.f;
                this.f = i3 - 1;
                xj32.e(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
