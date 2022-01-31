package defpackage;

import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: y96  reason: default package */
/* compiled from: Iterables.kt */
public final class y96 implements Iterable<T>, c96, Iterable {
    public final /* synthetic */ w96 f;

    public y96(w96 w96) {
        this.f = w96;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f.iterator();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }
}
