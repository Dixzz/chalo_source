package defpackage;

import com.google.android.gms.measurement.internal.zzn;

/* renamed from: lc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class lc4 implements Runnable {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ ac4 g;

    public lc4(ac4 ac4, zzn zzn) {
        this.g = ac4;
        this.f = zzn;
    }

    public final void run() {
        this.g.f.R();
        lg4 lg4 = this.g.f;
        zzn zzn = this.f;
        if (uy3.a() && lg4.j.g.l(q64.J0)) {
            lg4.f().b();
            lg4.P();
            gj1.j(zzn.f);
            e64 b = e64.b(zzn.B);
            e64 a2 = lg4.a(zzn.f);
            lg4.g().n.c("Setting consent, package, consent", zzn.f, b);
            lg4.s(zzn.f, b);
            if (b.f(a2)) {
                lg4.o(zzn);
            }
        }
    }
}
