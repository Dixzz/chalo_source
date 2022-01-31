package defpackage;

/* renamed from: ae3  reason: default package */
public final /* synthetic */ class ae3 implements Runnable {
    public final zd3 f;
    public final int g;
    public final sd3 h;

    public ae3(zd3 zd3, int i, sd3 sd3) {
        this.f = zd3;
        this.g = i;
        this.h = sd3;
    }

    public final void run() {
        zd3 zd3 = this.f;
        int i = this.g;
        sd3 sd3 = this.h;
        if (zd3.b.b(i)) {
            sd3.M("Local AnalyticsService processed last dispatch request");
        }
    }
}
