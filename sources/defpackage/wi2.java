package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: wi2  reason: default package */
public final class wi2 implements Iterable<Object>, Iterable {
    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return ui2.f3508a;
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Object> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }
}
