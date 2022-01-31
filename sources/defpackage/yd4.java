package defpackage;

/* renamed from: yd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class yd4 implements Runnable {
    public final /* synthetic */ e64 f;
    public final /* synthetic */ long g;
    public final /* synthetic */ int h;
    public final /* synthetic */ long i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ dd4 k;

    public yd4(dd4 dd4, e64 e64, long j2, int i2, long j3, boolean z) {
        this.k = dd4;
        this.f = e64;
        this.g = j2;
        this.h = i2;
        this.i = j3;
        this.j = z;
    }

    public final void run() {
        this.k.y(this.f);
        this.k.v(this.g, false);
        dd4.B(this.k, this.f, this.h, this.i, true, this.j);
    }
}
