package defpackage;

/* renamed from: id4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class id4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ dd4 g;

    public id4(dd4 dd4, long j) {
        this.g = dd4;
        this.f = j;
    }

    public final void run() {
        this.g.i().q.b(this.f);
        this.g.g().m.b("Session timeout duration set", Long.valueOf(this.f));
    }
}
