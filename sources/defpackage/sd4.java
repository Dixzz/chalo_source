package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: sd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class sd4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ dd4 j;

    public sd4(dd4 dd4, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.j = dd4;
        this.f = atomicReference;
        this.g = str;
        this.h = str2;
        this.i = z;
    }

    public final void run() {
        re4 x = this.j.f3331a.x();
        AtomicReference atomicReference = this.f;
        String str = this.g;
        String str2 = this.h;
        boolean z = this.i;
        x.b();
        x.s();
        x.y(new if4(x, atomicReference, null, str, str2, z, x.H(false)));
    }
}
