package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: a93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class a93 implements Iterator, j$.util.Iterator {
    public abstract byte a();

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
