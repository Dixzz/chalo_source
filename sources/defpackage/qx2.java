package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: qx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class qx2 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f3002a;

    public qx2(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f3002a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == qx2.class) {
            if (this == obj) {
                return true;
            }
            qx2 qx2 = (qx2) obj;
            return this.f3002a == qx2.f3002a && get() == qx2.get();
        }
    }

    public final int hashCode() {
        return this.f3002a;
    }
}
