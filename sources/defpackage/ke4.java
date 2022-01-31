package defpackage;

/* renamed from: ke4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ke4 implements Runnable {
    public final /* synthetic */ je4 f;
    public final /* synthetic */ je4 g;
    public final /* synthetic */ long h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ ie4 j;

    public ke4(ie4 ie4, je4 je4, je4 je42, long j2, boolean z) {
        this.j = ie4;
        this.f = je4;
        this.g = je42;
        this.h = j2;
        this.i = z;
    }

    public final void run() {
        this.j.A(this.f, this.g, this.h, this.i, null);
    }
}
