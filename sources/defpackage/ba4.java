package defpackage;

/* renamed from: ba4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ba4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ b64 g;

    public ba4(b64 b64, long j) {
        this.g = b64;
        this.f = j;
    }

    public final void run() {
        this.g.w(this.f);
    }
}
