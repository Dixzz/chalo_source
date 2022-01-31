package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: e66  reason: default package */
/* compiled from: Iterators.kt */
public abstract class e66 implements Iterator<Integer>, c96, j$.util.Iterator {
    public abstract int a();

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // j$.util.Iterator, java.util.Iterator
    public Integer next() {
        return Integer.valueOf(a());
    }

    @Override // j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
