package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: um2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class um2 implements Iterator<Map.Entry>, j$.util.Iterator {
    public int f = -1;
    public boolean g;
    public Iterator<Map.Entry> h;
    public final /* synthetic */ wm2 i;

    public /* synthetic */ um2(wm2 wm2) {
        this.i = wm2;
    }

    public final Iterator<Map.Entry> a() {
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
        if (this.f + 1 < this.i.g.size()) {
            return true;
        }
        if (this.i.h.isEmpty() || !a().hasNext()) {
            return false;
        }
        return true;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // j$.util.Iterator, java.util.Iterator
    public final /* synthetic */ Map.Entry next() {
        this.g = true;
        int i2 = this.f + 1;
        this.f = i2;
        return (Map.Entry) (i2 < this.i.g.size() ? this.i.g.get(this.f) : a().next());
    }

    @Override // j$.util.Iterator
    public final void remove() {
        if (this.g) {
            this.g = false;
            wm2 wm2 = this.i;
            int i2 = wm2.l;
            wm2.g();
            if (this.f < this.i.g.size()) {
                wm2 wm22 = this.i;
                int i3 = this.f;
                this.f = i3 - 1;
                wm22.e(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
