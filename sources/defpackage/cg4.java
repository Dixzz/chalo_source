package defpackage;

/* renamed from: cg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class cg4 implements Runnable {
    public long f;
    public long g;
    public final /* synthetic */ yf4 h;

    public cg4(yf4 yf4, long j, long j2) {
        this.h = yf4;
        this.f = j;
        this.g = j2;
    }

    public final void run() {
        this.h.b.f().u(new bg4(this));
    }
}
