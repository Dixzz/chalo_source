package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: eb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class eb3 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f954a;

    public eb3(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f954a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == eb3.class) {
            if (this == obj) {
                return true;
            }
            eb3 eb3 = (eb3) obj;
            return this.f954a == eb3.f954a && get() == eb3.get();
        }
    }

    public final int hashCode() {
        return this.f954a;
    }
}
