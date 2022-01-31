package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: md4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class md4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ dd4 g;

    public md4(dd4 dd4, long j) {
        this.g = dd4;
        this.f = j;
    }

    public final void run() {
        this.g.v(this.f, true);
        this.g.n().z(new AtomicReference<>());
    }
}
