package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: ew4  reason: default package */
public final class ew4 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1036a;

    public ew4(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f1036a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == ew4.class) {
            if (this == obj) {
                return true;
            }
            ew4 ew4 = (ew4) obj;
            return this.f1036a == ew4.f1036a && get() == ew4.get();
        }
    }

    public final int hashCode() {
        return this.f1036a;
    }
}
