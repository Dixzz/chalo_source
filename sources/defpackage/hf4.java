package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;

/* renamed from: hf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class hf4 implements Runnable {
    public final /* synthetic */ boolean f;
    public final /* synthetic */ zzz g;
    public final /* synthetic */ zzn h;
    public final /* synthetic */ zzz i;
    public final /* synthetic */ re4 j;

    public hf4(re4 re4, boolean z, zzz zzz, zzn zzn, zzz zzz2) {
        this.j = re4;
        this.f = z;
        this.g = zzz;
        this.h = zzn;
        this.i = zzz2;
    }

    public final void run() {
        re4 re4 = this.j;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        re4.v(ja4, this.f ? null : this.g, this.h);
        this.j.E();
    }
}
