package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: nd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class nd4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ dd4 g;

    public nd4(dd4 dd4, AtomicReference atomicReference) {
        this.g = dd4;
        this.f = atomicReference;
    }

    public final void run() {
        String str;
        synchronized (this.f) {
            try {
                AtomicReference atomicReference = this.f;
                dd4 dd4 = this.g;
                d64 d64 = dd4.f3331a.g;
                oa4 l = dd4.l();
                l.s();
                String str2 = l.c;
                Objects.requireNonNull(d64);
                ka4<String> ka4 = q64.L;
                if (str2 == null) {
                    str = ka4.a(null);
                } else {
                    str = ka4.a(d64.c.zza(str2, ka4.f2039a));
                }
                atomicReference.set(str);
                this.f.notify();
            } catch (Throwable th) {
                this.f.notify();
                throw th;
            }
        }
    }
}
