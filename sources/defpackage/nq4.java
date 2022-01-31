package defpackage;

import android.app.PendingIntent;

/* renamed from: nq4  reason: default package */
public abstract class nq4 {
    public abstract int a();

    public abstract long b();

    public abstract long c();

    public abstract long d();

    public abstract Integer e();

    public abstract PendingIntent f();

    public abstract PendingIntent g();

    public abstract PendingIntent h();

    public abstract PendingIntent i();

    public final PendingIntent j(pq4 pq4) {
        if (pq4.b() != 0) {
            if (pq4.b() == 1) {
                if (f() != null) {
                    return f();
                }
                if (k(pq4)) {
                    return h();
                }
            }
            return null;
        } else if (g() != null) {
            return g();
        } else {
            if (k(pq4)) {
                return i();
            }
            return null;
        }
    }

    public final boolean k(pq4 pq4) {
        return pq4.a() && b() <= d();
    }

    public abstract int l();

    public abstract String m();

    public abstract long n();

    public abstract int o();

    public abstract int p();
}
