package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: vw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class vw3 implements Iterable<Object>, Iterable {
    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return uw3.f3562a;
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Object> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }
}
