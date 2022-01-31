package defpackage;

import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: ef4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ef4 implements Runnable {
    public final /* synthetic */ boolean f;
    public final /* synthetic */ zzaq g;
    public final /* synthetic */ zzn h;
    public final /* synthetic */ String i;
    public final /* synthetic */ re4 j;

    public ef4(re4 re4, boolean z, boolean z2, zzaq zzaq, zzn zzn, String str) {
        this.j = re4;
        this.f = z2;
        this.g = zzaq;
        this.h = zzn;
        this.i = str;
    }

    public final void run() {
        re4 re4 = this.j;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Discarding data. Failed to send event to service");
            return;
        }
        re4.v(ja4, this.f ? null : this.g, this.h);
        this.j.E();
    }
}
