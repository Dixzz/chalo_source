package defpackage;

/* renamed from: xd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xd4 implements Runnable {
    public final /* synthetic */ e64 f;
    public final /* synthetic */ int g;
    public final /* synthetic */ long h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ dd4 j;

    public xd4(dd4 dd4, e64 e64, int i2, long j2, boolean z) {
        this.j = dd4;
        this.f = e64;
        this.g = i2;
        this.h = j2;
        this.i = z;
    }

    public final void run() {
        this.j.y(this.f);
        dd4.B(this.j, this.f, this.g, this.h, false, this.i);
    }
}
