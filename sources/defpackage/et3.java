package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: et3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class et3 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1028a;

    public et3(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f1028a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == et3.class) {
            if (this == obj) {
                return true;
            }
            et3 et3 = (et3) obj;
            return this.f1028a == et3.f1028a && get() == et3.get();
        }
    }

    public final int hashCode() {
        return this.f1028a;
    }
}
