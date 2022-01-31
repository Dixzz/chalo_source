package defpackage;

/* renamed from: hd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class hd4 implements Runnable {
    public final /* synthetic */ boolean f;
    public final /* synthetic */ dd4 g;

    public hd4(dd4 dd4, boolean z) {
        this.g = dd4;
        this.f = z;
    }

    public final void run() {
        boolean d = this.g.f3331a.d();
        boolean B = this.g.f3331a.B();
        this.g.f3331a.A = Boolean.valueOf(this.f);
        if (B == this.f) {
            this.g.f3331a.g().n.b("Default data collection state already set to", Boolean.valueOf(this.f));
        }
        if (this.g.f3331a.d() == d || this.g.f3331a.d() != this.g.f3331a.B()) {
            this.g.f3331a.g().k.c("Default data collection is different than actual status", Boolean.valueOf(this.f), Boolean.valueOf(d));
        }
        this.g.O();
    }
}
