package defpackage;

/* renamed from: l64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class l64 implements Runnable {
    public final /* synthetic */ uc4 f;
    public final /* synthetic */ j64 g;

    public l64(j64 j64, uc4 uc4) {
        this.g = j64;
        this.f = uc4;
    }

    public final void run() {
        this.f.r();
        if (hh4.a()) {
            this.f.f().u(this);
            return;
        }
        boolean z = this.g.c != 0;
        this.g.c = 0;
        if (z) {
            this.g.a();
        }
    }
}
