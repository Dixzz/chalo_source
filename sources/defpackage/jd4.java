package defpackage;

/* renamed from: jd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class jd4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ dd4 g;

    public jd4(dd4 dd4, long j) {
        this.g = dd4;
        this.f = j;
    }

    public final void run() {
        this.g.i().p.b(this.f);
        this.g.g().m.b("Minimum session duration set", Long.valueOf(this.f));
    }
}
