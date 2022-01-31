package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: gh2  reason: default package */
public final class gh2<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
    public Iterator<Map.Entry<K, Object>> f;

    public gh2(Iterator<Map.Entry<K, Object>> it) {
        this.f = it;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f.hasNext();
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f.next();
        return next.getValue() instanceof dh2 ? new fh2(next, null) : next;
    }

    @Override // j$.util.Iterator
    public final void remove() {
        this.f.remove();
    }
}
