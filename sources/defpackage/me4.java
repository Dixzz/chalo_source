package defpackage;

/* renamed from: me4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class me4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ ie4 g;

    public me4(ie4 ie4, long j) {
        this.g = ie4;
        this.f = j;
    }

    public final void run() {
        this.g.j().s(this.f);
        this.g.e = null;
    }
}
