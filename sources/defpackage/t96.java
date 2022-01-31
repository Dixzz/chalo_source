package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: t96  reason: default package */
/* compiled from: SequencesJVM.kt */
public final class t96<T> implements w96<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<w96<T>> f3324a;

    public t96(w96<? extends T> w96) {
        n86.e(w96, "sequence");
        this.f3324a = new AtomicReference<>(w96);
    }

    @Override // defpackage.w96
    public Iterator<T> iterator() {
        w96<T> andSet = this.f3324a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
