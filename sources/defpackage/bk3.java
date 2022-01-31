package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: bk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class bk3 implements Iterable<Object>, Iterable {
    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return zj3.f4183a;
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Object> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }
}
