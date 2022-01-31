package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: pd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class pd4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ dd4 i;

    public pd4(dd4 dd4, AtomicReference atomicReference, String str, String str2) {
        this.i = dd4;
        this.f = atomicReference;
        this.g = str;
        this.h = str2;
    }

    public final void run() {
        re4 x = this.i.f3331a.x();
        AtomicReference atomicReference = this.f;
        String str = this.g;
        String str2 = this.h;
        x.b();
        x.s();
        x.y(new gf4(x, atomicReference, null, str, str2, x.H(false)));
    }
}
