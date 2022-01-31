package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: wd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class wd4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ dd4 g;

    public wd4(dd4 dd4, AtomicReference atomicReference) {
        this.g = dd4;
        this.f = atomicReference;
    }

    public final void run() {
        synchronized (this.f) {
            try {
                AtomicReference atomicReference = this.f;
                dd4 dd4 = this.g;
                d64 d64 = dd4.f3331a.g;
                oa4 l = dd4.l();
                l.s();
                atomicReference.set(Double.valueOf(d64.p(l.c, q64.O)));
                this.f.notify();
            } catch (Throwable th) {
                this.f.notify();
                throw th;
            }
        }
    }
}
