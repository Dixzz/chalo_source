package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: og3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class og3 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2689a;

    public og3(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f2689a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == og3.class) {
            if (this == obj) {
                return true;
            }
            og3 og3 = (og3) obj;
            return this.f2689a == og3.f2689a && get() == og3.get();
        }
    }

    public final int hashCode() {
        return this.f2689a;
    }
}
