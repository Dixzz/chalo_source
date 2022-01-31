package defpackage;

import android.os.Handler;
import java.util.Objects;

/* renamed from: j64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class j64 {
    public static volatile Handler d;

    /* renamed from: a  reason: collision with root package name */
    public final uc4 f1885a;
    public final Runnable b;
    public volatile long c;

    public j64(uc4 uc4) {
        Objects.requireNonNull(uc4, "null reference");
        this.f1885a = uc4;
        this.b = new l64(this, uc4);
    }

    public abstract void a();

    public final void b(long j) {
        c();
        if (j >= 0) {
            Objects.requireNonNull((db2) this.f1885a.e());
            this.c = System.currentTimeMillis();
            if (!d().postDelayed(this.b, j)) {
                this.f1885a.g().f.b("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void c() {
        this.c = 0;
        d().removeCallbacks(this.b);
    }

    public final Handler d() {
        Handler handler;
        if (d != null) {
            return d;
        }
        synchronized (j64.class) {
            if (d == null) {
                d = new c24(this.f1885a.m().getMainLooper());
            }
            handler = d;
        }
        return handler;
    }
}
