package defpackage;

import android.os.Handler;
import java.util.Objects;

/* renamed from: cd3  reason: default package */
public abstract class cd3 {
    public static volatile Handler d;

    /* renamed from: a  reason: collision with root package name */
    public final ac3 f551a;
    public final Runnable b = new dd3(this);
    public volatile long c;

    public cd3(ac3 ac3) {
        Objects.requireNonNull(ac3, "null reference");
        this.f551a = ac3;
    }

    public final void a() {
        this.c = 0;
        b().removeCallbacks(this.b);
    }

    public final Handler b() {
        Handler handler;
        if (d != null) {
            return d;
        }
        synchronized (cd3.class) {
            if (d == null) {
                d = new ne3(this.f551a.f146a.getMainLooper());
            }
            handler = d;
        }
        return handler;
    }

    public abstract void c();

    public final boolean d() {
        return this.c != 0;
    }

    public final void e(long j) {
        a();
        if (j >= 0) {
            Objects.requireNonNull((db2) this.f551a.c);
            this.c = System.currentTimeMillis();
            if (!b().postDelayed(this.b, j)) {
                this.f551a.c().L("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
