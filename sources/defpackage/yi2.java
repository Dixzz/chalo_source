package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: yi2  reason: default package */
public final class yi2 implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
    public int f = -1;
    public boolean g;
    public Iterator<Map.Entry<K, V>> h;
    public final /* synthetic */ si2 i;

    public yi2(si2 si2, ti2 ti2) {
        this.i = si2;
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
        return (Map.Entry) (i2 < this.i.g.size() ? this.i.g.get(this.f) : a().next());
    }

    @Override // j$.util.Iterator
    public final void remove() {
        if (this.g) {
            this.g = false;
            si2 si2 = this.i;
            int i2 = si2.l;
            si2.g();
            if (this.f < this.i.g.size()) {
                si2 si22 = this.i;
                int i3 = this.f;
                this.f = i3 - 1;
                si22.d(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
