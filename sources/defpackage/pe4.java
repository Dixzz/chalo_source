package defpackage;

/* renamed from: pe4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class pe4 implements Runnable {
    public final /* synthetic */ je4 f;
    public final /* synthetic */ long g;
    public final /* synthetic */ ie4 h;

    public pe4(ie4 ie4, je4 je4, long j) {
        this.h = ie4;
        this.f = je4;
        this.g = j;
    }

    public final void run() {
        this.h.B(this.f, false, this.g);
        ie4 ie4 = this.h;
        ie4.e = null;
        re4 n = ie4.n();
        n.b();
        n.s();
        n.y(new xe4(n, null));
    }
}
