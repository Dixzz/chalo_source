package defpackage;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: se4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class se4 implements Runnable {
    public final /* synthetic */ boolean f;
    public final /* synthetic */ zzku g;
    public final /* synthetic */ zzn h;
    public final /* synthetic */ re4 i;

    public se4(re4 re4, boolean z, zzku zzku, zzn zzn) {
        this.i = re4;
        this.f = z;
        this.g = zzku;
        this.h = zzn;
    }

    public final void run() {
        re4 re4 = this.i;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Discarding data. Failed to set user property");
            return;
        }
        re4.v(ja4, this.f ? null : this.g, this.h);
        this.i.E();
    }
}
