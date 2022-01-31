package defpackage;

import defpackage.km6;

/* renamed from: rj6  reason: default package */
/* compiled from: RealConnection.kt */
public final class rj6 extends km6.c {
    public final /* synthetic */ lj6 i;
    public final /* synthetic */ ym6 j;
    public final /* synthetic */ xm6 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rj6(lj6 lj6, ym6 ym6, xm6 xm6, boolean z, ym6 ym62, xm6 xm62) {
        super(z, ym62, xm62);
        this.i = lj6;
        this.j = ym6;
        this.k = xm6;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i.a(-1, true, true, null);
    }
}
