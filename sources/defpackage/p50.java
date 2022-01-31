package defpackage;

/* renamed from: p50  reason: default package */
/* compiled from: UniversalSearchFeature */
public class p50 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;
    public final /* synthetic */ Exception h;
    public final /* synthetic */ String i;
    public final /* synthetic */ q50 j;

    public p50(q50 q50, String str, long j2, Exception exc, String str2) {
        this.j = q50;
        this.f = str;
        this.g = j2;
        this.h = exc;
        this.i = str2;
    }

    public void run() {
        q50.a(this.j, this.f, this.g, this.h.getMessage(), this.i);
    }
}
